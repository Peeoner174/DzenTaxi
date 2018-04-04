package com.peeoner174.msi.oneapril2.driver.adapter

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.peeoner174.msi.oneapril2.driver.producer.UserViewProducer

import java.util.ArrayList

class UserViewPagerAdapter : PagerAdapter() {
    private val viewProducerList = ArrayList<UserViewProducer>()

    private val tabTitles = arrayOf("ОБО МНЕ", "МОИ ПОЕЗДКИ")


    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }

    override fun getCount(): Int {
        return viewProducerList.size
    }

    fun addView(userViewProducer: UserViewProducer) {
        viewProducerList.add(userViewProducer)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return viewProducerList[position].view
    }
}
