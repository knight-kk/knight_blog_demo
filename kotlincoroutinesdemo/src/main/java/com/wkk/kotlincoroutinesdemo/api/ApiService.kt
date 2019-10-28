package com.wkk.kotlincoroutinesdemo.api

import com.wkk.kotlincoroutinesdemo.entity.Article
import com.wkk.kotlincoroutinesdemo.entity.PageEntity
import com.wkk.kotlincoroutinesdemo.entity.Result
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * Created by rtvt-03 on 2019-10-28.
 */
interface ApiService {

    @GET("article/list/{page}/json")
    suspend fun getArticleList(@Path("page") page: Int = 0): Result<PageEntity<Article>>


}