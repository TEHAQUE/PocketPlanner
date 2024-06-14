package com.example.pocketplaner.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pocketplaner.ui.theme.NotiEl

@Dao
interface NotiElDao {

    @Query("SELECT * FROM NotiEl")
    fun getAllNoti(): LiveData<List<NotiEl>>

    @Insert
    fun addNoti(noti : NotiEl)

    @Query("Delete FROM NotiEl where id = :id")
    fun deleteNoti(id : Int)
}