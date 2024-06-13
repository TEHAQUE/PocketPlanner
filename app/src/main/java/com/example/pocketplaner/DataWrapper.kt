package com.example.pocketplaner

import android.app.Application
import androidx.room.Room
import com.example.pocketplaner.dataBase.NotiDataBase

class DataWrapper : Application() {
    companion object{
        lateinit var notiDataBase : NotiDataBase
    }

    override fun onCreate() {
        super.onCreate()
        notiDataBase = Room.databaseBuilder(
            applicationContext,
            NotiDataBase::class.java,
            NotiDataBase.NAME
        ).build()
    }
}