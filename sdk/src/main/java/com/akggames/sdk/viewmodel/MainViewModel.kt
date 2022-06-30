package com.akggames.sdk.viewmodel

import ApiService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.akg.troove.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val retrofitService: ApiService) : ViewModel() {

    fun sendOTP(email :String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = retrofitService.sendOTP(email)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}