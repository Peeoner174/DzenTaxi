package com.peeoner174.msi.oneapril2.UserActivity.View

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.UserActivity.ViewProducer

class OnePageView(view: View, appCompatActivity: AppCompatActivity) : ViewProducer(view, appCompatActivity) {

    private var recyclerView: RecyclerView? = null

    override fun onCreateView() {
        recyclerView = view.findViewById<View>(R.id.rv_drivers_list) as RecyclerView
    }
}
