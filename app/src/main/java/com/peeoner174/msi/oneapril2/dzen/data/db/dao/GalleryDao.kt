package com.peeoner174.msi.oneapril2.dzen.data.db.dao


import android.arch.persistence.room.*
import com.peeoner174.msi.oneapril2.dzen.data.model.Gallery
import com.peeoner174.msi.oneapril2.dzen.data.model.Trip
//Методы для работы с БД
@Dao
interface GalleryDao{

    @Query("SELECT * FROM gallery")
    fun getAll(): List<Gallery>

//    @Query("SELECT * FROM gallery WHERE url =  url ")
//    fun getByUser(user_image: String): List<Trip>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(gallery: Gallery)

    @Insert
    fun insertAll(gallery: List<Gallery>)

    @Update
    fun update(gallery: List<Gallery>)

    @Query("DELETE FROM gallery")
    fun delete()

}