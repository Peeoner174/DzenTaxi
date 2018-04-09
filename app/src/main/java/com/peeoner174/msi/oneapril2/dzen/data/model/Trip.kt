package com.peeoner174.msi.oneapril2.dzen.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

//Создаёт таблицу по указанному POJO-классу
@Entity(tableName = "trips")
data class Trip  (@PrimaryKey
                  val id: String,
                  val title: String,
                  val place: String,
                  val date: String,
                  val notes: String,
                  val photo: String,
                  val user_image: String,
                  val photo_gallery: String,
                  val user_name: String

){/**Формирует список требуемого типа, который будет хранить данные, переданные с сервера**/
    class List: ArrayList<Trip>()

}

