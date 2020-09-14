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
            text_view.text = newTemp.toString()
        }

        model.temp.observe(this, tempObserver)

        main_button.setOnClickListener {
            val anotherTemp = 100
            model.temp.setValue(anotherTemp)
        }
    }
}