package com.wkk.motionlayoutdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.Constraints
import com.wkk.motionlayoutdemo.databinding.ActivityCodeControlBinding


/**
 * 演示代码控制
 * Created by wkk on 2020/11/9.
 */
class CodeControlActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCodeControlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCodeControlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.motionLayout.getConstraintSet(R.id.end)

        binding.motionLayout.setDebugMode(MotionLayout.DEBUG_SHOW_PATH)


        binding.btnState1.setOnClickListener {
            //通过id获取ConstraintSet
            val constraintSet = binding.motionLayout.getConstraintSet(R.id.end)
            //通过id获取Constraint
            constraintSet.getConstraint(R.id.box).apply {
                //设置layout 的一些属性
                //↓↓这行代码↓↓ =>layout_constraintTop_toTopOf="parent"
                layout.topToTop = Constraints.LayoutParams.PARENT_ID
                layout.bottomToBottom = Constraints.LayoutParams.PARENT_ID
                layout.endToEnd = Constraints.LayoutParams.PARENT_ID
                //transform 可以改变旋转缩放等属性
                transform.rotationY = 180f
                transform.rotationX = 0f
                transform.scaleY=2f
                transform.scaleX=2f
                propertySet.alpha = 0.1f
            }

        }

        binding.btnState2.setOnClickListener {
            val constraintSet = binding.motionLayout.getConstraintSet(R.id.end)
            constraintSet.getConstraint(R.id.box).apply {
                layout.topToTop = Constraints.LayoutParams.PARENT_ID
                layout.endToEnd = Constraints.LayoutParams.PARENT_ID
                //去除约束将View 放到右上角
                layout.bottomToBottom = Constraints.LayoutParams.UNSET
                transform.rotationX = 180f
                transform.rotationY = 0f
            }
        }
    }

}