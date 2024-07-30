package com.example.appuiclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

// ViewPager2를 제어하는(?) Adapter입니다. ListAdapter랑은 별개의 Adapter입니다.
class ViewPagerAdapter(activity: AppCompatActivity, private val data: String) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                val fragment = TransportResultFragment()
                fragment.arguments = Bundle().apply {
                    putString(TransportResultFragment.STRING, data)
                }
                fragment
            }

            1 -> ResultChoiceFragment()
            else -> TransportResultFragment()    // defalt Fragment
        }
    }
}