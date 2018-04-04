package com.peeoner174.msi.oneapril2.driver.view

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

import com.peeoner174.msi.oneapril2.driver.producer.UserViewProducer

//Так как из-за недостатка времени аутентификацию я решил не делать(будет только один пользователь)
//Вся информация о нём указана в XML, потом будет переделанно

class FirstPageUserView(view: View, appCompatActivity: AppCompatActivity) : UserViewProducer(view, appCompatActivity) {

    override fun onCreateView() {
    }
}
