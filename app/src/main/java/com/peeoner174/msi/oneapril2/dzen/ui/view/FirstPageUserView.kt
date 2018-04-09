package com.peeoner174.msi.oneapril2.dzen.ui.view

import android.app.Application
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.TextureView
import android.view.View
import android.widget.TextView
import com.peeoner174.msi.oneapril2.App
import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.dzen.data.model.User
import com.peeoner174.msi.oneapril2.dzen.producer.UserInfoLoad

import com.peeoner174.msi.oneapril2.dzen.producer.UserViewProducer
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import com.peeoner174.msi.oneapril2.MySingleton

class FirstPageUserView(view: View, appCompatActivity: AppCompatActivity) : UserViewProducer(view, appCompatActivity) {

    private var name_user_TV: TextView? = null
    private var phone_user_TV: TextView? = null
    private var email_user_TV: TextView? = null
    private var web_user_TV: TextView? = null
    private var city_user_TV: TextView? = null
    private val user: UserInfoLoad = UserInfoLoad()
    private val userId = MySingleton.getInstance()


    override fun onCreateView() {

        launch(UI) {
            val cashJob = user.loadUser()
                showUser(cashJob.await())
        }


        name_user_TV = view.findViewById<View>(R.id.tv_nickname) as TextView
        phone_user_TV = view.findViewById<View>(R.id.tv_number_phone) as TextView
        email_user_TV = view.findViewById<View>(R.id.tv_email) as TextView
        web_user_TV = view.findViewById<View>(R.id.tv_web) as TextView
        city_user_TV = view.findViewById<View>(R.id.tv_city) as TextView


    }

    private fun showUser(user: List<User>){
        val index = userId.myVariable
        Log.d("SessionId", index.toString())
        name_user_TV?.text = user[index].full_name
        phone_user_TV?.text = user[index].phone
        email_user_TV?.text = user[index].email
        web_user_TV?.text = user[index].website
        city_user_TV?.text = user[index].city


    }
}
