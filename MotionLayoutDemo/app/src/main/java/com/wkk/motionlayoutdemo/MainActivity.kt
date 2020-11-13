package com.wkk.motionlayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wkk.motionlayoutdemo.databinding.ActivityMainBinding
import com.wkk.motionlayoutdemo.ext.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHWTel.setOnClickListener {
            startActivity<HuaweiTelActivity>()
        }

        binding.btnCodeOperation.setOnClickListener {
            startActivity<CodeControlActivity>()
        }

        binding.btnViewPager.setOnClickListener {
            startActivity<ViewPagerDemoActivity>()
        }

        binding.btnEasterEggs.setOnClickListener {
            startActivity<EasterEggs11Activity>()
        }
    }
}