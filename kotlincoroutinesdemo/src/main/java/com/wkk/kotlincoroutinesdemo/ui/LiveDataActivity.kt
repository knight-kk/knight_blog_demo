package com.wkk.kotlincoroutinesdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.wkk.kotlincoroutinesdemo.R
import kotlinx.android.synthetic.main.activity_live_data.*
import kotlinx.coroutines.delay


class LiveDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        val liveData: LiveData<Float> = liveData {
            while (true) {
                val fetchData = fetchData()
                emit(fetchData)
                delay(10_000)//1000*10 //10s更新一下温度
                Log.i("LiveDataActivity","执行中……")
            }
        }

        liveData.observe(this, androidx.lifecycle.Observer {
            tvWeather.text = resources.getString(R.string.weather, it)
            Log.i("LiveDataActivity","温度更新……")
        })
    }
    /**
     *  模拟网络获取温度
     * @return Float
     */
    private suspend fun fetchData(): Float {
        delay(500)
        return (Math.random() * 20 + 10).toFloat()
    }



    override fun onDestroy() {
        super.onDestroy()
        Log.i("LiveDataActivity","onDestroy……")
    }

}
