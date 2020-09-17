package com.akul.uwueather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val model: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //observer that updates UI
        val tempObserver = Observer<Int> {newTemp ->
            //update UI
            temp_text_view.text = newTemp.toString()
        }

        val summaryObserver = Observer<String> { newSummary ->
            summary_text_view.text = newSummary
        }

        val locationObserver = Observer<String> {newLocation ->
            location_text_view.text = newLocation
        }

        model.temp.observe(this, tempObserver)
        model.summary.observe(this, summaryObserver)
        model.location.observe(this, locationObserver)

        main_button.setOnClickListener {
            model.temp.setValue(3)
            model.summary.setValue("fuck this shit, I'm out")
            model.location.setValue("uwu land, uwu")
        }
    }
}