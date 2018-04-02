package com.peeoner174.msi.oneapril2.UserActivity

import android.support.v7.app.AppCompatActivity
import android.view.View

abstract class ViewProducer(view: View, private val appCompatActivity: AppCompatActivity) {

    var view: View
        protected set

    init {
        this.view = view
        onCreateView()
    }

    abstract fun onCreateView()

}
