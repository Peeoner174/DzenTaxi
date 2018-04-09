package com.peeoner174.msi.oneapril2.dzen.producer

import android.support.v7.app.AppCompatActivity
import android.view.View
//Абстрактный класс для создания View
abstract class UserViewProducer(view: View, private val appCompatActivity: AppCompatActivity) {

    var view: View

    init {
        this.view = view
        onCreateView()
    }

    abstract fun onCreateView()

}
