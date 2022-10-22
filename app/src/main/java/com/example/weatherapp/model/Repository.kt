package com.example.weatherapp.model

import com.example.weatherapp.domain.City
import com.example.weatherapp.domain.Weather

interface Repository {
    fun getListWeather(): List<Weather>
    fun getWeather(city: City): Weather
}