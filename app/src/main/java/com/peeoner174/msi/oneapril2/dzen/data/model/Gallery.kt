package com.peeoner174.msi.oneapril2.dzen.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable

/** Parcelable - интерфейс сериализации объектов оптимизированный для Android**/
@Entity(tableName = "gallery")
data class Gallery(var name: String,
                   @PrimaryKey
                   var url: String
) : Parcelable {  //Для передачи кастомных объектов между активити, благодаря чему экономится трафик
    //и значительно увеличивается скорость загрузки изображений

    class List : ArrayList<Gallery>()

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    /** пишет в объект Parcel содержимое объекта **/
    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(url)
    }

    companion object {
        @JvmField/** Реализует создание из ранее сериализованных данных исходных объектов **/
        val CREATOR: Parcelable.Creator<Gallery> = object : Parcelable.Creator<Gallery> {
            override fun createFromParcel(source: Parcel): Gallery = Gallery(source)
            override fun newArray(size: Int): Array<Gallery?> = arrayOfNulls(size)
        }
    }
}