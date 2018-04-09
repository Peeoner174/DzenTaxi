package com.peeoner174.msi.oneapril2.dzen.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.MySingleton

class LoginActivity : AppCompatActivity() {

     lateinit var loginBtn: Button
     lateinit var registerBtn: Button
     lateinit var loginEt: EditText
     lateinit var passwordEt: EditText
     var user = MySingleton.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // установка ресурса разметки дизайна через идентификатор ресурса

        loginBtn = findViewById<Button>(R.id.btLogin)
        registerBtn = findViewById<Button>(R.id.btRegister)
        loginEt = findViewById<EditText>(R.id.etLogin)
        passwordEt = findViewById<EditText>(R.id.etPassword)
        //Реализуем интерфейс OnClickListener, определяем для него метод onClick, где v - View - элемент, который был нажат.
        //Вместо полноценной регистрации пока заглушка
        val onClickListener = View.OnClickListener { v ->
            when (v.id) {
                R.id.btLogin -> {val mainIntend = Intent(this@LoginActivity, TapleActivity::class.java)
                                startActivity(mainIntend)
//                    if((loginEt.text.toString()=="Pavel"|| loginEt.text.toString()=="Pavel ") && passwordEt.text.toString()=="0000")
//                    {
//                        user.myVariable = 0
//                        val mainIntend = Intent(this@LoginActivity, TapleActivity::class.java)
//                        startActivity(mainIntend)
//                    }
//                    else if((loginEt.text.toString()=="Admin"|| loginEt.text.toString()=="Admin ") && passwordEt.text.toString()=="0000")
//                    {
//                        user.myVariable = 1
//                        Log.d("Admin", user.myVariable.toString())
//                        val mainIntend = Intent(this@LoginActivity, TapleActivity::class.java)
//                        startActivity(mainIntend)
//                    }
//
//                    else  Toast.makeText(this,
//                            "Войти не удалось. Проверьте, что вы правильно вводите логин и пароль. Спасибо!", Toast.LENGTH_SHORT).show()
                }

                R.id.btRegister -> {
                }
                else -> true
            }
        }

        loginBtn.setOnClickListener(onClickListener)
        registerBtn.setOnClickListener(onClickListener)
    }
}