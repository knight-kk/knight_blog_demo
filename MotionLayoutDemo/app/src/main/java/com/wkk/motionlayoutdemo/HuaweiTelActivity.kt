package com.wkk.motionlayoutdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wkk.motionlayoutdemo.databinding.ActivityHuaweiTelBinding
import com.wkk.motionlayoutdemo.databinding.ItemTelBinding

/**
 * 仿华为手机EMUI11的拨号界面
 * Created by wkk on 2020/11/9.
 */
class HuaweiTelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHuaweiTelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val list = MutableList(50) { "电话号码$it" }
        binding.recyclerView.adapter = TelAdapter(list)


        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                //RecyclerView 滑动时触发动画，隐藏数字键盘
                if (newState != RecyclerView.SCROLL_STATE_IDLE && binding.root.currentState == binding.root.startState) {
                    binding.root.transitionToEnd()
                }
            }

        })

        //点击拨号按钮 显示数字键盘
        binding.imgPhone.setOnClickListener {
            if (binding.root.currentState == binding.root.endState) {
                binding.root.transitionToStart()
            }
        }

    }

    class TelAdapter(private val tels: List<String>) :
        RecyclerView.Adapter<TelAdapter.TelViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TelViewHolder(parent)

        override fun onBindViewHolder(holder: TelViewHolder, position: Int) {
            holder.binding.tvTel.text = tels[position]
        }

        override fun getItemCount() = tels.size

        class TelViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_tel, parent, false)
        ) {
            val binding = ItemTelBinding.bind(itemView)
        }
    }
}



