package com.example.weatherapp.model

import com.example.weatherapp.domain.City
import com.example.weatherapp.domain.Weather
import com.example.weatherapp.viewModel.AppState

class RepositoryRemote: Repository{
    override fun getListWeather(): List<Weather> {
        Thread{
            Thread.sleep(2000L)
        }.start()
        return listOf(Weather())
    }

    override fun getWeather(city: City): Weather {
        return Weather()
    }
}