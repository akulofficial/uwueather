package com.akul.uwueather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class WeatherViewModel(): ViewModel() {

    val temp: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val summary: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        val currentWeather: WeatherModel = Repo().loadCurrentWeather()
        summary.value = currentWeather.summary
        temp.value = currentWeather.temp
    }

}