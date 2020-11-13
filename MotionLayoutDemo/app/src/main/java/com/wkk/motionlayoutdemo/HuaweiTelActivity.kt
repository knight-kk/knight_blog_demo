package com.wkk.motionlayoutdemo

import android.graphics.drawable.LayerDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat
import com.wkk.motionlayoutdemo.databinding.ActivityHuaweiTelBinding
/**
 * 仿华为手机EMUI11的拨号界面
 * Created by wkk on 2020/11/9.
 */
class HuaweiTelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHuaweiTelBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}