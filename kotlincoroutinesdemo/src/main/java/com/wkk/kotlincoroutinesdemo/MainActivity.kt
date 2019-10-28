package com.wkk.kotlincoroutinesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wkk.kotlincoroutinesdemo.adapter.ArticleAdapter
import com.wkk.kotlincoroutinesdemo.api.RetrofitManger
import com.wkk.kotlincoroutinesdemo.etx.openActivity
import com.wkk.kotlincoroutinesdemo.etx.toast
import com.wkk.kotlincoroutinesdemo.ui.LifecycleScopeActivity
import com.wkk.kotlincoroutinesdemo.ui.LiveDataActivity
import com.wkk.kotlincoroutinesdemo.ui.ViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
            openActivity(ViewModelActivity::class.java)

        }

        btn2.setOnClickListener {
            openActivity(LiveDataActivity::class.java)

        }

        btn3.setOnClickListener {
            openActivity(LifecycleScopeActivity::class.java)

        }


    }
}
