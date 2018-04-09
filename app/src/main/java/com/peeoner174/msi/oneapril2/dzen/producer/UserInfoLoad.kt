package com.peeoner174.msi.oneapril2.dzen.producer

import com.google.gson.Gson
import com.peeoner174.msi.oneapril2.App
import com.peeoner174.msi.oneapril2.dzen.data.model.Trip
import com.peeoner174.msi.oneapril2.dzen.data.model.User
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import okhttp3.OkHttpClient
import okhttp3.Request

class UserInfoLoad {
    //Ассинхронная загрузка данных при помощи корутин
    /**async(CommonPool) - карутина создаёт background-поток**/
    fun loadUser() = async(CommonPool) {
        //Создать клиент для HTTP - запросов
        val client = OkHttpClient()
        //Формирует запрос
        val request = Request.Builder()
                .url("https://raw.githubusercontent.com/Peeoner174/DzenTaxi/master/users")
                .build()
        //Исполняет запрос
        val response = client.newCall(request)!!.execute()
        //Обрабатывает полученные данные(сохраняет в переменную в виде строки)
        val responseText = response?.body()!!.string()
        /**Десериализация данных из JSON в Java-класс
         *Указываем к объекту какого типа нужно привести строку(этот тип вернёт функция)
         **/
        val users = Gson().fromJson(responseText, User.List::class.java)

        users
    }


    fun loadUserFromCache(app: App) = async(CommonPool) {
        app.database.userDao().getAll()
    }

    fun loadToCashe(app: App, users: List<User>) = async(CommonPool){
        app.database.userDao().insertAll(users)
    }
}