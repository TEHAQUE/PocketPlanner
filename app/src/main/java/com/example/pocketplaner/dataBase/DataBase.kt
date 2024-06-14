package com.example.pocketplaner.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pocketplaner.ui.theme.NotiEl
import com.example.pocketplaner.ui.theme.SubEl

@Database(entities = [NotiEl::class, SubEl::class], version = 1)
@TypeConverters(Convert::class)
abstract class DataBase : RoomDatabase() {
    companion object {
        const val NAME = "PocketPlannerDB"
    }
    abstract fun getNotiDao(): NotiElDao
    abstract fun getSubDao(): SubElDao
}
