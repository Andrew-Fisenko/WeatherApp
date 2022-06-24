package com.example.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.repository.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: RepositoryImpl = RepositoryImpl()
) :
    ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getWeatherFromLocalSourceWorld(){
        getDataFromLocalSource()
    }

    fun getDataFromLocalSource(isRussian:Boolean) {
        liveDataToObserve.postValue(AppState.Loading)
        Thread {
             sleep(2000)
             if (isRussian){
                 liveDataToObserve.postValue(AppState.Success(repositoryImpl.getWeatherFromLocalStorageRus()))
             } else {
                 liveDataToObserve.postValue(AppState.Success(repositoryImpl.getWeatherFromLocalStorageWorld()))
             }
//                var r = Random.nextInt(0, 10)
//                if(r>5)
//                else
//                    liveDataToObserve.postValue(AppState.Error(IllegalStateException()))
        }.start()
    }
}