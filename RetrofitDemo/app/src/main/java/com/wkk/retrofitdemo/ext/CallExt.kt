package com.wkk.retrofitdemo.ext

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.wkk.retrofitdemo.entity.*

  fun <T> Call<Result<T>>.asyncExecute(
      success: (data: Result<T>) -> Unit,
      failed: (msg: String) -> Unit = {}
) {
    enqueue(object : Callback<Result<T>> {
        override fun onResponse(call: Call<Result<T>>, response: Response<Result<T>>) {
            if (response.isSuccessful) {
                val result = response.body()
                if (result != null) {
                    success(result)
                }else{
                    failed("result is null")
                }
            } else {
                failed("http code=${response.code()},message=${response.message()}")
            }
        }
        override fun onFailure(call: Call<Result<T>>, t: Throwable) {
            failed("请求失败")
        }
    })
}