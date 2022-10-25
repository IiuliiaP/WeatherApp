package com.example.weatherapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.getDefaultCity
import com.example.weatherapp.model.Repository
import com.example.weatherapp.model.RepositoryLocal
import com.example.weatherapp.model.RepositoryRemote
import java.lang.Thread.sleep
import kotlin.reflect.KClass

class WeatherDetailsVewModel (val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>(), )
    : ViewModel() {

    lateinit var repository:Repository

    fun getLivaData():MutableLiveData<AppState>{
        chooseRepository()
        return liveData
    }

    fun chooseRepository(){
        repository = if(isConnection()){
            RepositoryRemote()
        }else {
            RepositoryLocal()
        }
    }

    fun sendRequest(){
        liveData.value = AppState.Loading
        if((0..5).random()==2){
            liveData.postValue(AppState.Error(throw IllegalStateException("ошибка")))
        }else{
        liveData.postValue(AppState.Success(repository.getWeather(getDefaultCity())))}
    }
   private fun isConnection(): Boolean{
       return false
   }
}