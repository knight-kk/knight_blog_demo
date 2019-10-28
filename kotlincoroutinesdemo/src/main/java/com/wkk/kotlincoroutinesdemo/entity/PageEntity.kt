package com.wkk.kotlincoroutinesdemo.entity

/**
 *
 * Created by rtvt-03 on 2019-09-12.
 */
class PageEntity<T>(
    val curPage:Int,
    val offset:Int,
    val over:Boolean,
    val size:Int,
    val PageCount:Int,
    val total:Int,
    val datas:List<T>

)