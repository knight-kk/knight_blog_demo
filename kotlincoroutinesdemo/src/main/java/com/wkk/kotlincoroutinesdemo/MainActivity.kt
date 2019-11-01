package com.wkk.kotlincoroutinesdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wkk.kotlincoroutinesdemo.etx.openActivity
import com.wkk.kotlincoroutinesdemo.ui.ArticleActivity
import com.wkk.kotlincoroutinesdemo.ui.LifecycleScopeActivity
import com.wkk.kotlincoroutinesdemo.ui.LiveDataActivity
import kotlinx.android.synthetic.main.activity_main.*


/**
 *
 * Created by wkk on 2019-10-28.
 *
 * @blog https://blog.csdn.net/knight1996
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            openActivity(ArticleActivity::class.java)

        }

        btn2.setOnClickListener {
            openActivity(LiveDataActivity::class.java)

        }

        btn3.setOnClickListener {
            openActivity(LifecycleScopeActivity::class.java)

        }


    }
}
