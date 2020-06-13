package com.wkk.retrofitdemo

import com.wkk.retrofitdemo.entity.Book
import com.wkk.retrofitdemo.entity.Result
import com.wkk.retrofitdemo.entity.User
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    /**
     * GET 请求方式 路由 friend_list
     * 请求参数是 page 可选参数
     * 相应数据是json格式，根据json数据格式来定义方法返回类型
     */
    @GET("friend_list")
    fun getFriends(
        @Query("page") page: Int = 1,
        @Query("sort") sort: String = "desc"
    ): Call<Result<List<User>>>


    @GET("friend_list")
    fun getData(  @Query("page") page: Int = 1,
                  @Query("sort") sort: String = "desc"): Call<ResponseBody>


    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Result<User?>>


    @GET("user/{id}")
    fun getUserInfo(@Path("id") id: Int): Call<Result<User?>>

    @POST("add_book")
    fun addBook(@Body book: Book): Call<Result<Book>>

    @Multipart
    @POST("modify_user_info")
    fun modifyUserInfo(
        @Part("name") name: String,
        @Part file: MultipartBody.Part
    ): Call<Result<Nothing?>>

    @POST("modify_user_info")
    fun modifyUserInfo(@Body body: RequestBody): Call<Result<Nothing?>>




}