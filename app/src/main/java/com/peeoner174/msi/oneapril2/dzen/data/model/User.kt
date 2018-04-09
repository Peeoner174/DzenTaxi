package com.peeoner174.msi.oneapril2.dzen.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class User(
        @PrimaryKey
        var id: String,
        var full_name: String,
        var phone: String,
        var email: String,
        var website: String,
        var city: String,
        var main_photo: String,
        var avatar: String
){
    class List: ArrayList<User>()


}