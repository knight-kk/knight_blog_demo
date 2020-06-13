package com.wkk.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.children
import androidx.core.widget.ContentLoadingProgressBar
import com.wkk.retrofitdemo.entity.Book
import com.wkk.retrofitdemo.entity.Result
import com.wkk.retrofitdemo.entity.User
import com.wkk.retrofitdemo.ext.asyncExecute
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import java.io.File

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val apiService by lazy {
        val retrofit = Retrofit.Builder()
            //api的baseUrl (* android高版本(好像是从android9.0开始)不支持http请求 要想请求成功需要在AndroidManifest.xml
            // application标签添加android:usesCleartextTraffic="true")
            .baseUrl(BASE_URL)
            // ① 添加一个Gson转换器，用于把请求到的json数据转换成对应的java对象
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //使用create方法创建ApiService 接口实例
        retrofit.create(ApiService::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout.children.forEach { it.setOnClickListener(this) }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn1 -> getFriends()
            R.id.btn2 -> login()
            R.id.btn3 -> getUserInfo()
            R.id.btn4 -> addBook()
            R.id.btn5 -> modifyUserInfo2()
        }
    }

    private fun getFriends() {
        apiService.getFriends().enqueue(object : Callback<Result<List<User>>> {
            override fun onFailure(call: Call<Result<List<User>>>, t: Throwable) {
                Log.i(TAG, "${t.message}")
            }

            override fun onResponse(
                call: Call<Result<List<User>>>,
                response: Response<Result<List<User>>>
            ) {
                if (response.isSuccessful) {
                    Log.i(TAG, "success")
                    Log.i(TAG, response.body().toString())
                } else {
                    Log.i(
                            TAG,
                        "http code=${response.code()},message=${response.message()}"
                    )
                }
            }
        })
    }

    private fun login() {
        apiService.login("kk@gmail.com", "123456").enqueue(object : Callback<Result<User?>> {
            override fun onFailure(call: Call<Result<User?>>, t: Throwable) {
                Log.i(TAG, "login--onFailure")
            }

            override fun onResponse(call: Call<Result<User?>>, response: Response<Result<User?>>) {
                if (response.isSuccessful) {
                    val result = response.body()
                    if (result != null) {
                        if (result.code == 0) {
                            result.data?.let {
                                Log.i(TAG, "login success$it")
                            }
                        } else {
                            Log.i(TAG, result.msg)
                        }
                    }
                }
            }
        })
    }


    private fun getUserInfo() {
        apiService.getUserInfo(1).asyncExecute(success = {
            Log.i(TAG, "getUserInfo--success,$it")
        }, failed = {
            Log.i(TAG, "getUserInfo--failed,$it")
        })
    }


    private fun addBook() {
        apiService.addBook(Book("《第一行代码》", "郭霖", "xxxx", "xxxx")).asyncExecute(success = {
            Log.i(TAG, "addBook--success,$it")
        }, failed = {
            Log.i(TAG, "addBook--success,$it")
        })
    }

    private fun modifyUserInfo() {
        val imageData = assets.open("android_logo.png").readBytes()
        val requestBody = RequestBody.create(MultipartBody.FORM, imageData)

        val part = MultipartBody.Part.createFormData("avatar", "android_logo.png", requestBody)
        //如果上传成功，文件会在服务器段所以根目录的upload文件夹下
        apiService.modifyUserInfo("kk", part).asyncExecute(success = {
            Log.i(TAG, "modifyUserInfo: success ,$it")
        }, failed = {
            Log.i(TAG, "modifyUserInfo: failed,$it")
        })
    }


    private fun modifyUserInfo2() {
        val imageData = assets.open("android_logo.png").readBytes()
        val imageDataBody = RequestBody.create(MultipartBody.FORM, imageData)
        //构建一个表单body
        val multipartBody = MultipartBody.Builder()
                //添加普通的key-value 表单数据
            .addFormDataPart("name", "kk")
                //添加文件，第一个参数是api要求的参数、第二个参数是要发送文件的文件名称，第三个参数是文件数据对应的RequestBody
            .addFormDataPart("avatar", "android_logo.png", imageDataBody)
            .build()
        apiService.modifyUserInfo(multipartBody).asyncExecute(success = {
            Log.i(TAG, "modifyUserInfo2: success $it")
        }, failed = {
            Log.i(TAG, "modifyUserInfo2: failed $it")
        })
    }

    companion object{
        //切换至运行api 的电脑局域网地址
        private const val IP_ADDRESS="192.168.31.9"
        private const val BASE_URL = "http://$IP_ADDRESS:8080/"

        private const val TAG = "MainActivity"
    }


}