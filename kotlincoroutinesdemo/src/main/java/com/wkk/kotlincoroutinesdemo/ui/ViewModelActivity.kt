package com.wkk.kotlincoroutinesdemo.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.wkk.kotlincoroutinesdemo.R
import com.wkk.kotlincoroutinesdemo.adapter.ArticleAdapter
import com.wkk.kotlincoroutinesdemo.etx.toast
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity() {
    private val adapter by lazy { ArticleAdapter() }
    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter

        viewModel.articleListData.observe(this, Observer { list ->
            loadProgress.visibility = View.GONE
            adapter.submitList(list)
        })

        viewModel.errorMsg.observe(this, Observer {
            if (it != null) {
                toast(it)
            }
        })

        btn.setOnClickListener {
            loadProgress.visibility = View.VISIBLE
            viewModel.fetchArticleList(1)
        }
    }
}
