package com.example.appuiclone

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// ViewPager2를 제어하는(?) Adapter입니다. ListAdapter랑은 별개의 Adapter입니다.
class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int) = when (position) {
        0 -> TransportResultFragment()
        1 -> ResultChoiceFragment()
        else -> TransportResultFragment()    // defalt Fragment
    }
}