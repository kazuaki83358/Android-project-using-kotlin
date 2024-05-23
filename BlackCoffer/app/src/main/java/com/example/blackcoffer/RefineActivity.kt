package com.example.blackcoffer

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar

class RefineActivity : AppCompatActivity() {

    private var btn1Clicked = false
    private var btn2Clicked = false
    private var btn3Clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refine)

        val toolbar = findViewById<Toolbar>(R.id.Revinetoolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "" // Set toolbar title to empty string

        val backButton = findViewById<ImageView>(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }

        val availabilitySpinner = findViewById<Spinner>(R.id.availability_spinner)
        val distanceSpinner = findViewById<Spinner>(R.id.Distance_spinner)

        // Create an ArrayAdapter for the availability options
        ArrayAdapter.createFromResource(
            this,
            R.array.availability_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            availabilitySpinner.adapter = adapter
        }

        // Create an ArrayAdapter for the distance options
        ArrayAdapter.createFromResource(
            this,
            R.array.distance_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            distanceSpinner.adapter = adapter
        }
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)

        btn1.setOnClickListener {
            if (btn1Clicked) {
                btn1.setBackgroundResource(R.drawable.button_bg)
                btn1.setTextColor(resources.getColor(R.color.black)) // Set original text color
            } else {
                btn1.setBackgroundResource(R.drawable.newbackground_button)
                btn1.setTextColor(resources.getColor(R.color.white))
            }
            btn1Clicked = !btn1Clicked
        }

        btn2.setOnClickListener {
            if (btn2Clicked) {
                btn2.setBackgroundResource(R.drawable.button_bg)
                btn2.setTextColor(resources.getColor(R.color.black)) // Set original text color
            } else {
                btn2.setBackgroundResource(R.drawable.newbackground_button)
                btn2.setTextColor(resources.getColor(R.color.white))
            }
            btn2Clicked = !btn2Clicked
        }

        btn3.setOnClickListener {
            if (btn3Clicked) {
                btn3.setBackgroundResource(R.drawable.button_bg)
                btn3.setTextColor(resources.getColor(R.color.black)) // Set original text color
            } else {
                btn3.setBackgroundResource(R.drawable.newbackground_button)
                btn3.setTextColor(resources.getColor(R.color.white))
            }
            btn3Clicked = !btn3Clicked
        }
    }
}
