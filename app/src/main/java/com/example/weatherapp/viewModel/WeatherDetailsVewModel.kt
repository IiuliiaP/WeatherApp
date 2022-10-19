package com.example.weatherapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep
import kotlin.reflect.KClass

class WeatherDetailsVewModel (val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()) : ViewModel() {

    fun sendRequest(){
        liveData.value = AppState.Loading
        Thread{
            sleep(2000L)
            liveData.postValue(AppState.Success(Any()))
        }.start()
    }
}