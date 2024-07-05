package com.example.pocketplaner

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocketplaner.ui.theme.NotiEl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.Date
import java.time.Instant

class NotiViewModel : ViewModel() {
    val notiElDao = DataWrapper.dataBase.getNotiDao()

    val notiList: LiveData<List<NotiEl>> = notiElDao.getAllNoti()

    fun addNoti(title: String, cost: Float) {
        viewModelScope.launch(Dispatchers.IO) {
            notiElDao.addNoti(NotiEl(title = title, cost = cost, date = Date.from(Instant.now())))
        }
    }

    fun deleteNoti(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            notiElDao.deleteNoti(id)
        }
    }
}