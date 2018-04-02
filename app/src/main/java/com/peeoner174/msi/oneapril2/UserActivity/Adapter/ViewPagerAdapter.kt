package com.peeoner174.msi.oneapril2.UserActivity.Adapter

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.peeoner174.msi.oneapril2.UserActivity.ViewProducer

import java.util.ArrayList

class ViewPagerAdapter : PagerAdapter() {
    private val viewProducerList = ArrayList<ViewProducer>()

    private val tabTitles = arrayOf("Tab1", "Tab2")


    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }

    override fun getCount(): Int {
        return viewProducerList.size
    }

    fun addView(viewProducer: ViewProducer) {
        viewProducerList.add(viewProducer)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return viewProducerList[position].view
    }
}
