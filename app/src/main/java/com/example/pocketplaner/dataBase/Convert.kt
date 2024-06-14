package com.example.pocketplaner.dataBase

import androidx.room.TypeConverter
import java.util.Date

class Convert {
    @TypeConverter
    fun fromDate(date: Date) : Long{
        return date.time
    }
    @TypeConverter
    fun ToDate(time : Long) : Date{
        return Date(time)
    }
}