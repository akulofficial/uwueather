package com.akul.uwueather

import android.app.Application
import android.location.Geocoder
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class WeatherViewModel(application: Application): AndroidViewModel(application) {

    val temp: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val summary: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val location: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        val currentWeather: WeatherModel = Repo().loadCurrentWeather()
        summary.value = currentWeather.summary
        temp.value = currentWeather.temp
        location.value = getLocation(currentWeather.latitude, currentWeather.longtitude)
    }

    fun getLocation(lat: Double, lon: Double): String {
        val geocoder = Geocoder(getApplication())
        val address = geocoder.getFromLocation(lat, lon, 1)
        val city = address[0].locality
        val stateName = address[0].adminArea
        return "$city, $stateName"
    }



    //some code here will use setValue(T) or postValue(T) to change the data objects using
    //load current weather

}