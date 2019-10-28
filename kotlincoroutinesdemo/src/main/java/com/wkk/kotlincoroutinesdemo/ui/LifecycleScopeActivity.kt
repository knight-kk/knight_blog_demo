package com.wkk.kotlincoroutinesdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.wkk.kotlincoroutinesdemo.R

class LifecycleScopeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_scope)

        Log.i("LifecycleScopeActivity", "onCreate")


        lifecycleScope.launchWhenResumed {
            Log.i("LifecycleScopeActivity", "launchWhenResumed")
        }

        lifecycleScope.launchWhenStarted {
            Log.i("LifecycleScopeActivity", "launchWhenStarted")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifecycleScopeActivity", "onStart")


    }

    override fun onResume() {
        super.onResume()
        Log.i("LifecycleScopeActivity", "onResume")
    }
}
