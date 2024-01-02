package com.example.lucky_number_app

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        //declaring layout
        val textView2 : TextView = findViewById(R.id.textView2)
        var textView3 : TextView = findViewById(R.id.textView3)
        val btn2 : Button = findViewById(R.id.btn2)
        var user_name = receiveUserName()
        var lucky_number = randomNumber()
        textView3.text = lucky_number.toString()
        btn2.setOnClickListener(){
            sharingData(user_name,lucky_number)
        }
    }
    //receiving data(user name) from first activity to activity2
    fun receiveUserName():String{
        var bundle : Bundle? = intent.extras
        var username = bundle?.get("name").toString()
        return username
    }
    //generating random number for lucky number
    fun randomNumber():Int{
        val random = Random.nextInt(1000)
        return random
    }
    //sharing the result user name and lucky number
    @SuppressLint("QueryPermissionsNeeded")
    fun sharingData(name: String, number: Int) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "$name is lucky today")
        intent.putExtra(Intent.EXTRA_TEXT, "His lucky number is $number")

        // Verify that there is an activity to handle the intent
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "No suitable app found to handle the intent", Toast.LENGTH_SHORT).show()
        }
    }
}