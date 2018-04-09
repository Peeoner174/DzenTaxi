package com.peeoner174.msi.oneapril2.dzen.producer

import com.google.gson.Gson
import com.peeoner174.msi.oneapril2.dzen.data.model.Note
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import okhttp3.OkHttpClient
import okhttp3.Request.Builder

class NoteDataLoaderWeb {
//Ассинхронная загрузка данных при помощи корутин
    /**async(CommonPool) - карутина создаёт background-поток**/
    fun loadNote(url: String?) = async(CommonPool) {
        //Создаём клиент для HTTP - запросов
        val client = OkHttpClient()
        //Формируем запрос
        val request = Builder()
                .url(url)
                .build()
        //Исполняем запрос
        val response = client.newCall(request)!!.execute()
        //Обрабатываем полученные данные(сохраняем в переменную в виде строки)
        val responseText = response?.body()!!.string()
        /**Десериализация данных из JSON в Java-класс
         *Указываем к объекту какого типа нужно привести строку(этот тип вернёт функция)
         **/
        val notes = Gson().fromJson(responseText, Note.List::class.java)
        notes
    }


}