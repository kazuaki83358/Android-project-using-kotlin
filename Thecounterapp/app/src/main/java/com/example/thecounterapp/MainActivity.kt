package com.example.thecounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var counter: TextView
    lateinit var start: Button
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializing view
        counter = findViewById(R.id.counter)
        start = findViewById(R.id.start)

        start.setOnClickListener{
            //increment the count
            count++

            //updating the value of text view or counter
            counter.text = count.toString()
        }
    }
}