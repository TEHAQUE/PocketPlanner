package com.example.pocketplaner

import android.app.Application
import androidx.room.Room
import com.example.pocketplaner.dataBase.DataBase

class DataWrapper : Application() {
    companion object{
        lateinit var dataBase : DataBase
    }

    override fun onCreate() {
        super.onCreate()
        dataBase = Room.databaseBuilder(
            applicationContext,
            DataBase::class.java,
            DataBase.NAME
        ).build()
    }
}