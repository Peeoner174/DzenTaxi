package com.peeoner174.msi.oneapril2.dzen.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.peeoner174.msi.oneapril2.dzen.data.db.dao.GalleryDao
import com.peeoner174.msi.oneapril2.dzen.data.db.dao.TripDao
import com.peeoner174.msi.oneapril2.dzen.data.db.dao.UserDao
import com.peeoner174.msi.oneapril2.dzen.data.model.Gallery
import com.peeoner174.msi.oneapril2.dzen.data.model.Trip
import com.peeoner174.msi.oneapril2.dzen.data.model.User

/**Основной класс по работе с БД
 * [entities] - какие таблицы будут в будут в БД
 * [version] - версия базы
 * **/
@Database(entities = [Trip::class, Gallery::class, User::class], version = 4)
abstract class AppDatabase: RoomDatabase(){

    abstract fun tripDao(): TripDao
    abstract fun galleryDao(): GalleryDao
    abstract fun userDao(): UserDao

}