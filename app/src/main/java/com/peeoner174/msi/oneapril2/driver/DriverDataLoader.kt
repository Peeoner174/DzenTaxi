package com.peeoner174.msi.oneapril2.driver

import com.peeoner174.msi.oneapril2.driver.model.Driver
import com.google.gson.Gson
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import okhttp3.OkHttpClient
import okhttp3.Request.Builder
/**Загрузка данных с сервера в список**/
class DriverDataLoader {

    fun loadUsers() = async(CommonPool) {
        //Создаём клиент для HTTP - запросов
        val client = OkHttpClient()
        //Формируем запрос
        val request = Builder()
                .url("https://raw.githubusercontent.com/Peeoner174/DzenTaxi/master/ServerJson")
                .build()
        //Исполняем запрос
        val response = client.newCall(request)!!.execute()
        //Обрабатываем полученные данные(сохраняем в переменную в виде строки)
        val responseText = response?.body()!!.string()
        /**Десериализация данных из JSON в Java-класс
        *[responseText] - стока, в которой информация в формате JSON
        *[Driver.List] - Указываем к объекту какого типа нужно привести строку(этот тип вернёт функция)
        **/
        val drivers = Gson().fromJson(responseText, Driver.List::class.java)
        drivers
    }


}