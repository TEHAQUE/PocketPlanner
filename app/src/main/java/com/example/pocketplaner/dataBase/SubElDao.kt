package com.example.pocketplaner.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pocketplaner.ui.theme.SubEl

@Dao
interface SubElDao {

    @Query("SELECT * FROM SubEl")
    fun getAllSub(): LiveData<List<SubEl>>

    @Insert
    fun addSub(sub : SubEl)

    @Query("Delete FROM SubEl where id = :id")
    fun deleteSub(id : Int)
}