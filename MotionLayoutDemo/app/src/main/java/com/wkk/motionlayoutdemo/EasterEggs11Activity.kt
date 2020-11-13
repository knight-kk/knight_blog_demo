package com.wkk.motionlayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wkk.motionlayoutdemo.databinding.ActivityEasterEggs11Binding

/**
 * 仿Android 11 彩蛋
 * Created by wkk on 2020/10/23.
 */
class EasterEggs11Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEasterEggs11Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}