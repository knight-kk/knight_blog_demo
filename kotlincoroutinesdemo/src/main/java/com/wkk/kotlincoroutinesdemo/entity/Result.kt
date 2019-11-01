package com.wkk.kotlincoroutinesdemo.entity

/**
 *
 * Created by rtvt-03 on 2019-09-12.
 */
data class Result<T>(val code: Int, val errorMsg: String?, val data: T)