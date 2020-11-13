package com.wkk.motionlayoutdemo.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.res.use
import com.wkk.motionlayoutdemo.R

/**
 * Created by wkk on 2020/11/9.
 */
class CrossFadeImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var layerDrawable: LayerDrawable? = null

    /**
     * 控制src图片透明度
     *  value [0,1]
     */
    var srcAlpha = 0f
        set(value) {
            field = value
            layerDrawable?.getDrawable(0)?.alpha = (255*value).toInt()
            invalidate()
        }
    /**
     * 控制altSrc图片透明度
     *  value [0,1]
     */
    var altSrcAlpha = 0f
        set(value) {
            field = value
            layerDrawable?.getDrawable(1)?.alpha = (255*value).toInt()
            invalidate()
        }

    init {
        val a = getContext().obtainStyledAttributes(attrs, R.styleable.CrossFadeImageView)
        val drawable = a.getDrawable(R.styleable.CrossFadeImageView_altSrc)
        a.recycle()
        if (drawable != null) {
            drawable.alpha = 0
            layerDrawable = LayerDrawable(arrayOf(getDrawable(), drawable))
            super.setImageDrawable(layerDrawable)
        }
    }
}

private const val TAG = "CrossFadeImageView"