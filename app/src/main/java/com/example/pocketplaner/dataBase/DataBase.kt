package com.example.pocketplaner.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pocketplaner.ui.theme.NotiEl

@Database(entities = [NotiEl::class], version = 1)
@TypeConverters(Convert::class)
abstract class NotiDataBase : RoomDatabase() {
    companion object{
        const  val NAME = "Noti_DB"
    }
    abstract fun getNotiDao() : NotiElDao
}