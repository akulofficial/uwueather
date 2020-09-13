package com.akul.uwueather

import android.content.Context
import java.io.IOException
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Repo {

    fun loadCurrentWeather(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use{ it.readText() }
        } catch(ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}