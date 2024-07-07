package com.example.pocketplaner.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pocketplaner.ui.theme.NotiEl

@Dao
interface NotiElDao {

    @Query("SELECT * FROM NotiEl WHERE id NOT IN (1, 2)")
    fun getAllNoti(): LiveData<List<NotiEl>>

    @Insert
    fun addNoti(noti : NotiEl)

    @Query("Delete FROM NotiEl where id = :id")
    fun deleteNoti(id : Int)

    @Query("SELECT SUM(cost) FROM NotiEl WHERE id NOT IN (1, 2)")
    fun getTotalCost(): LiveData<Float>

    @Query("SELECT title FROM NotiEl WHERE id = 2")
    fun getUserName(): LiveData<String>

    @Query("SELECT cost FROM NotiEl WHERE id = 2")
    fun getUserBalance(): LiveData<Float>

    @Query("SELECT cost FROM NotiEl WHERE id = 1")
    fun getUserSalary(): LiveData<Float>

    @Query("SELECT SUM(cost) FROM NotiEl WHERE id % 2 = 0 AND id NOT IN (1, 2)")
    fun getSumEx(): LiveData<Float>

    @Query("SELECT SUM(cost) FROM NotiEl WHERE id % 3 = 0 AND id NOT IN (1, 2)")
    fun getSumLs(): LiveData<Float>

    @Query("SELECT SUM(cost) FROM NotiEl WHERE id % 7 = 0 AND id NOT IN (1, 2)")
    fun getSumSa(): LiveData<Float>

    @Query("UPDATE NotiEl SET title = :title, cost = :cost WHERE id = 2")
    fun setUser(title: String, cost: Float)

    @Query("UPDATE NotiEl SET cost = :cost WHERE id = 1")
    fun setUserSal(cost: Float)
}