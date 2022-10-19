package com.example.weatherapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeatherListViewModel(val liveData: MutableLiveData<Any> = MutableLiveData<Any>()) : ViewModel()