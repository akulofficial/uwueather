package com.akul.uwueather

import android.content.Context
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.beust.klaxon.lookup
import java.io.IOException

class Repo {

    fun loadCurrentWeather(context: Context): WeatherModel {
        //convert JSON file to deserializable string
        val currentWeatherJson = context.assets.open("weather.json").bufferedReader().use {
            it.readText()
        }

        //build JSON from generated string
        val stringBuilder: StringBuilder = StringBuilder(currentWeatherJson)
        val parser: Parser = Parser.default()
        val json: JsonObject = parser.parse(stringBuilder) as JsonObject

        //go down one level of JSON to access "data" object
        val data: JsonArray<String> = json.lookup("data")

        //extract needed values for model object
        val temp: Int = data.int("temp")[0] as Int
        val summary: String = data.obj("weather").string("description")[0] as String

        return WeatherModel(summary, temp)
    }
}