package com.peeoner174.msi.oneapril2.dzen.producer

import com.google.gson.Gson
import com.peeoner174.msi.oneapril2.App
import com.peeoner174.msi.oneapril2.dzen.data.model.Trip
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import okhttp3.OkHttpClient
import okhttp3.Request.Builder

class TripDataLoaderWeb {
//Ассинхронная загрузка данных при помощи корутин
    /**async(CommonPool) - карутина создаёт background-поток**/
    fun loadTrip() = async(CommonPool) {
        //Создать клиент для HTTP - запросов
        val client = OkHttpClient()
        //Формирует запрос
        val request = Builder()
                .url("https://raw.githubusercontent.com/Peeoner174/DzenTaxi/master/tripleJson")
                .build()
        //Исполняет запрос
        val response = client.newCall(request)!!.execute()
        //Обрабатывает полученные данные(сохраняет в переменную в виде строки)
        val responseText = response?.body()!!.string()
        /**Десериализация данных из JSON в Java-класс
         *Указываем к объекту какого типа нужно привести строку(этот тип вернёт функция)
         **/
        val trips = Gson().fromJson(responseText, Trip.List::class.java)

        trips
    }

    fun loadTripFromCache(app: App) = async(CommonPool) {
        app.database.tripDao().getAll()
    }

    fun loadToCashe(app: App, trips: List<Trip>) = async(CommonPool){
        app.database.tripDao().insertAll(trips)
    }

}