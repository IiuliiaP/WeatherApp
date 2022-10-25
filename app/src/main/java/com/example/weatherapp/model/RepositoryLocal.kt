package com.example.weatherapp.model

import com.example.weatherapp.domain.City
import com.example.weatherapp.domain.Weather

class RepositoryLocal: Repository {
    override fun getListWeather(): List<Weather> {
        return listOf(Weather())
    }

    override fun getWeather(city: City): Weather {
        return Weather()
    }
}