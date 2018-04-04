package com.peeoner174.msi.oneapril2.driver.producer

import com.google.gson.Gson
import com.peeoner174.msi.oneapril2.driver.model.Trip
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import okhttp3.OkHttpClient
import okhttp3.Request.Builder
/**Загрузка данных с сервера в список**/
class TripDataLoaderWeb {
//Ассинхронная загрузка данных при помощи корутин
    /**async(CommonPool) - карутина создаёт background-поток**/
    fun loadTrip() = async(CommonPool) {


        //Создаём клиент для HTTP - запросов
        val client = OkHttpClient()
        //Формируем запрос
        val request = Builder()
                .url("https://raw.githubusercontent.com/Peeoner174/DzenTaxi/master/simple2Json")
                .build()
        //Исполняем запрос
        val response = client.newCall(request)!!.execute()
        //Обрабатываем полученные данные(сохраняем в переменную в виде строки)
        val responseText = response?.body()!!.string()
        /**Десериализация данных из JSON в Java-класс
        *[responseText] - строка, в которой информация в формате JSON
        *[*git remote add origin https://github.com/Peeoner174/DZen_Taxi.git.List] - Указываем к объекту какого типа нужно привести строку(этот тип вернёт функция)
        **/
        val trips = Gson().fromJson(responseText, Trip.List::class.java)
        trips
    }


}