package com.example.igdb.external

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager

class CustomViewPagerAdapter(
    fragmentManager: FragmentManager,
    private val fragments: List<Fragment>
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

    interface OnPageChangeListener : ViewPager.OnPageChangeListener {
        fun onPageChanged(position: Int)

        override fun onPageSelected(position: Int) {
            onPageChanged(position)
        }

        override fun onPageScrollStateChanged(state: Int) {

        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {

        }
    }
}