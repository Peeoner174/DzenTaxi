package com.peeoner174.msi.oneapril2.driver.view

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View

import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.driver.producer.UserViewProducer
//Содержит список поездок пользователя
class SecondPageUserView(view: View, appCompatActivity: AppCompatActivity) : UserViewProducer(view, appCompatActivity) {

    private var recyclerView: RecyclerView? = null

    override fun onCreateView() {
        recyclerView = view.findViewById<View>(R.id.rv_trips_list) as RecyclerView
    }
}
