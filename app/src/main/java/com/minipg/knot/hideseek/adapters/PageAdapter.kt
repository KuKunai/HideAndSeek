package com.minipg.knot.hideseek.adapters

import android.app.FragmentManager
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.minipg.knot.hideseek.fragment.FirstFragment
import com.minipg.knot.hideseek.fragment.SecondFragment
import com.minipg.knot.hideseek.fragment.ThirdFragment

/**
 * Created by Knot on 9/11/2017.
 */
class PageAdapter(fm: android.support.v4.app.FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return FirstFragment()
            1 -> return SecondFragment()
            2 -> return ThirdFragment()
        }
        return FirstFragment()
    }

    override fun getCount(): Int {
        return 3
    }
}