package com.peeoner174.msi.oneapril2.UserActivity.View

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.UserActivity.ViewProducer

class TwoPageView(view: View, appCompatActivity: AppCompatActivity) : ViewProducer(view, appCompatActivity) {
    internal lateinit var textView: TextView

    override fun onCreateView() {
        textView = view.findViewById<View>(R.id.two_view_page_user_text) as TextView
    }
}
