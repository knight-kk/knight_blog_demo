package com.wkk.kotlincoroutinesdemo.etx

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import androidx.annotation.IntDef

/**
 *
 * Created by rtvt-03 on 2019-10-28.
 */


fun Context.toast(msg: String, duration: Int = LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}

fun Activity.openActivity(cls: Class<*>) {
    startActivity(Intent(this, cls))
}