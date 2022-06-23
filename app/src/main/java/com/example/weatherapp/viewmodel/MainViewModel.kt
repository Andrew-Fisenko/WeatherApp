package com.example.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep

class MainViewModel(private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()) :
    ViewModel() {

        fun getLiveData() = liveDataToObserve

        fun getDataFromRemoteSource() {
            liveDataToObserve.postValue(AppState.Loading)
            Thread {
                sleep(2000)
                liveDataToObserve.postValue(AppState.Success(Any()))
            }.start()
        }
}