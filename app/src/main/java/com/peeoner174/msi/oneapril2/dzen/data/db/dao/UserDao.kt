package com.peeoner174.msi.oneapril2.dzen.data.db.dao

import android.arch.persistence.room.*
import com.peeoner174.msi.oneapril2.dzen.data.model.Trip
import com.peeoner174.msi.oneapril2.dzen.data.model.User

//Методы для работы с БД
@Dao
interface UserDao{

    @Query("SELECT * FROM users")
    fun getAll(): List<User>

//    @Query("SELECT * FROM users WHERE id = 1 ")
//    fun getByUser(id: String): List<User>

    @Insert
    fun insertAll(trips: List<User>)

    @Update
    fun update(posts: List<User>)

    @Query("DELETE FROM users")
    fun delete()

}