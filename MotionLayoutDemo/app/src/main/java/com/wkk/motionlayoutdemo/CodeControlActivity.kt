package com.wkk.motionlayoutdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.Constraints
import androidx.core.view.get
import com.wkk.motionlayoutdemo.databinding.ActivityCodeControlBinding
import kotlinx.android.synthetic.main.activity_code_control.*


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
                transform.scaleY = 2f
                transform.scaleX = 2f
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

        /**
         * fix 动画在执行时，点击动画会重头开始问题
         * 1.去掉xml中的<OnClick/>
         * 2.自己编写对应的点击事件控制动画
         * motionLayout 中有currentState、startState、endState
         * startState 就是Transition的motion:constraintSetStart设置的id，endState同理
         * 上述结论 在motionLayout的setTransition(int beginId, int endId)方法中可以看出
         */
        binding.root.setOnClickListener {
//            Log.i(TAG, "currentState: ${binding.motionLayout.currentState}")
//            Log.i(TAG, "startState: ${binding.motionLayout.startState},R.id.start: ${R.id.start}")
//            Log.i(TAG, "startState: ${binding.motionLayout.endState},R.id.end: ${R.id.end}")

            //运动中currentState的值是-1 不做处理
            if (binding.motionLayout.currentState == -1) {
                return@setOnClickListener
            }

            if (binding.motionLayout.currentState == binding.motionLayout.startState) {
                binding.motionLayout.transitionToEnd()
            } else if (binding.motionLayout.currentState == binding.motionLayout.endState) {
                binding.motionLayout.transitionToStart()
            }
        }
    }

}

private const val TAG = "CodeControlActivity"