package com.peeoner174.msi.oneapril2.dzen.data.db.dao

import android.arch.persistence.room.*
import com.peeoner174.msi.oneapril2.dzen.data.model.Trip
//Методы для работы с БД
@Dao
interface TripDao {

    @Query("SELECT * FROM trips")
    fun getAll(): List<Trip>

//    @Query("SELECT * FROM trips WHERE user_image = user_image")
//    fun getByUser(user_image: String): List<Trip>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(trip: Trip)

    @Insert
    fun insertAll(trips: List<Trip>)

    @Update
    fun update(posts: List<Trip>)

    @Query("DELETE FROM trips")
    fun delete()

}