package com.akul.uwueather

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class WeatherViewModel(
    val context: Context,
    val temp: MutableLiveData<Int>,
    val summary: MutableLiveData<String>) : ViewModel() {

    init {
        val currentWeather: WeatherModel = Repo(context).loadCurrentWeather(context)
        summary.value = currentWeather.summary
        temp.value = currentWeather.temp
    }

}