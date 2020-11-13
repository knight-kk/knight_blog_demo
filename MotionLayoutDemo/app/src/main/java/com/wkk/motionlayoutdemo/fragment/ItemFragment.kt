package com.wkk.motionlayoutdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.annotation.DrawableRes
import androidx.core.os.bundleOf
import com.wkk.motionlayoutdemo.R
import com.wkk.motionlayoutdemo.databinding.FragmentItemBinding


private const val AVATAR_ID = "avatar_id"

class ItemFragment : Fragment(R.layout.fragment_item) {

    private var avatarId: Int = R.drawable.avatar1
    private var _binding: FragmentItemBinding? = null
    private val binding: FragmentItemBinding
        get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            avatarId = it.getInt(AVATAR_ID, R.drawable.avatar1)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentItemBinding.bind(view)
        binding.imageView.setImageResource(avatarId)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


    companion object {
        @JvmStatic
        fun newInstance(@DrawableRes resId: Int) =
            ItemFragment().apply {
                arguments = bundleOf(AVATAR_ID to resId)
            }
    }
}