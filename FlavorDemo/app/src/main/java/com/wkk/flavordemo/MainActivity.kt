package com.wkk.flavordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.wkk.mylibrary.MyLibrary
//import com.wkk.mylibrary2.MyLibrary2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn1).setOnClickListener {
            PayHelper.pay()
        }
        findViewById<Button>(R.id.btn2).setOnClickListener {
            MyLibrary.test()
        }

        findViewById<Button>(R.id.btn3).setOnClickListener {
//            MyLibrary2.test()
        }

    }
}