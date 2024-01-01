package com.example.unitconverterapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //declaring EditText,Button,TextView in main activity
        val edit : EditText = findViewById(R.id.edit_text_id)
        val button : Button = findViewById(R.id.Covert_now)
        val resultText : TextView = findViewById(R.id.text_view)

        button.setOnClickListener{
            val kilos : Double = edit.text.toString().toDouble()
            resultText.setText(""+convertToPounds(kilos) + "\nPounds")
        }
    }
    fun convertToPounds(kilos : Double):Double{
        val pounds = kilos * 2.20462
        return pounds
    }
}