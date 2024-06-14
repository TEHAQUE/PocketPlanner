package com.example.pocketplaner

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocketplaner.ui.theme.SubEl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.Date
import java.time.Instant

class SubViewModel : ViewModel() {
    val subElDao = DataWrapper.dataBase.getSubDao()

    val subList : LiveData<List<SubEl>> = subElDao.getAllSub()

    fun addSub(title: String, cost : Float){
        viewModelScope.launch(Dispatchers.IO) {
            subElDao.addSub(SubEl(title = title, cost = cost, date = Date.from(Instant.now())))
        }
    }
    fun deleteSub(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            subElDao.deleteSub(id)
        }
    }
}