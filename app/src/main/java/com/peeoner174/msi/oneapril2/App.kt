package com.peeoner174.msi.oneapril2

import android.app.Application
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.Room
import com.peeoner174.msi.oneapril2.dzen.data.db.AppDatabase
////import com.squareup.leakcanary.LeakCanary

/**
 * Класс Application - это базовый класс приложения android. Создается раньше любого другого класса
 * приложения. Singleton
 * **/
class App: Application(){

    lateinit var database: AppDatabase //Singleton

    override fun onCreate() {
        super.onCreate()

//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
//        // Normal app init code...

        MySingleton.initInstance()

        database = Room.databaseBuilder(this, AppDatabase::class.java, "dzen")
                .fallbackToDestructiveMigration()
                .build()

    }



}