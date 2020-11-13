package com.wkk.motionlayoutdemo.ext

import android.app.Activity
import android.content.Intent
import android.content.res.Resources

/**
 *
 * Created by wkk on 2020/9/28.
 */
val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

inline fun <reified T : Activity> Activity.startActivity() {
    startActivity(Intent(this, T::class.java))
}