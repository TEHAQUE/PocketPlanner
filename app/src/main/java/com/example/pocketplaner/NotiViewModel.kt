package com.example.pocketplaner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _addNotiResult = MutableLiveData<String>()
    val addNotiResult: LiveData<String> = _addNotiResult

    private val _deleteNotiResult = MutableLiveData<String>()
    val deleteNotiResult: LiveData<String> = _deleteNotiResult

    private val _setUserResult = MutableLiveData<String>()
    val setUserResult: LiveData<String> = _setUserResult

    private val _setUserSalResult = MutableLiveData<String>()
    val setUserSalResult: LiveData<String> = _setUserSalResult

    fun addNoti(title: String, cost: Float) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                notiElDao.addNoti(NotiEl(title = title, cost = cost, date = Date.from(Instant.now())))
                _addNotiResult.postValue("${title} has been added to the model, witch cost of ${cost}.")
            } catch (e: Exception) {
                _addNotiResult.postValue("Failed to add notification: ${e.message}")
            }
        }
    }

    fun deleteNoti(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                notiElDao.deleteNoti(id)
                _deleteNotiResult.postValue("Notification with id $id deleted successfully")
            } catch (e: Exception) {
                _deleteNotiResult.postValue("Failed to delete notification: ${e.message}")
            }
        }
    }

    fun getTotalCost(): LiveData<Float> {
        return notiElDao.getTotalCost()
    }

    fun getUserName(): LiveData<String> {
        return notiElDao.getUserName()
    }

    fun getUserBalance(): LiveData<Float> {
        return notiElDao.getUserBalance()
    }

    fun getUserSalary(): LiveData<Float> {
        return notiElDao.getUserSalary()
    }
    fun getSumEx(): LiveData<Float> {
        return notiElDao.getSumEx()
    }

    fun getSumLs(): LiveData<Float> {
        return notiElDao.getSumLs()
    }

    fun getSumSa(): LiveData<Float> {
        return notiElDao.getSumSa()
    }

    fun setUser(title: String, cost: Float) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                notiElDao.setUser(title, cost)
                _setUserResult.postValue("User information updated successfully to name: ${title}, balance: ${cost}$")
            } catch (e: Exception) {
                _setUserResult.postValue("Failed to update user information: ${e.message}")
            }
        }
    }


    fun setUserSal(cost: Float) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                notiElDao.setUserSal(cost)
                _setUserSalResult.postValue("User salary updated successfully to ${cost}$")
            } catch (e: Exception) {
                _setUserSalResult.postValue("Failed to update user salary: ${e.message}")
            }
        }
    }
}