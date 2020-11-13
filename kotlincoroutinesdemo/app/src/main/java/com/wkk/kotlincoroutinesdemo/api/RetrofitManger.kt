package com.wkk.kotlincoroutinesdemo.api

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.*

/**
 *
 * Created by rtvt-03 on 2019-10-28.
 */
object RetrofitManger {

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().enableComplexMapKeySerialization().create()))
            .build()
    }

    private val okHttpClient by lazy {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = Interceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .method(original.method, original.body)
            val request = requestBuilder.build()
            chain.proceed(request)
        }


        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(interceptor)
            .connectTimeout(120L, TimeUnit.SECONDS)
            .readTimeout(120L, TimeUnit.SECONDS)
            .writeTimeout(120L, TimeUnit.SECONDS)
            .build()
    }

}