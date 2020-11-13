package com.wkk.motionlayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.wkk.motionlayoutdemo.databinding.ActivityViewPagerDemoBinding
import com.wkk.motionlayoutdemo.fragment.ItemFragment

class ViewPagerDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewPagerDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val avatars =
            arrayOf(R.drawable.avatar1, R.drawable.avatar2, R.drawable.avatar3, R.drawable.avatar4)
        val fragments = Array(avatars.size) { position ->
            ItemFragment.newInstance(avatars[position])
        }
        val titles = arrayOf("大雄","胖虎","小夫","静香")

        val adapter = object :
            FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getCount(): Int = fragments.size

            override fun getItem(position: Int): Fragment = fragments[position]

            override fun getPageTitle(position: Int): CharSequence = titles[position]
        }
        binding.viewpager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewpager)

        binding.viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                binding.motionLayout.root.progress =
                    (position + positionOffset) / (adapter.count - 1)
            }

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {}

        })


    }
}


