package com.example.weatherapp.domain

import android.os.Parcel
import android.os.Parcelable

data class Weather (
    val city: City = getDefaultCity(),
    val temperature: Int = 0,
    val feelsLike: Int = 0

        )
data class City(val name: String)

fun getDefaultCity() = City("Moscow")