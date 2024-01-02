package com.example.fun_project_1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class ResultActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var textView5 : TextView = findViewById(R.id.textView5)
        val btn3 : Button = findViewById(R.id.btn3)
        val randomQuote: String = getRandomQuote()
        var userName = receiveUserName()
        var userDateOfBirth = receiveUserDob()
        //text view declaration
        textView5.text = randomQuote
        btn3.setOnClickListener(){
            sharingData(userName,userDateOfBirth,randomQuote)
        }
    }
    fun receiveUserName():String{
        var bundle : Bundle? = intent.extras
        var userName = bundle?.get("name").toString()
        return userName
    }
    fun receiveUserDob():String{
        var bundle : Bundle? = intent.extras
        var userDob = bundle?.get("dob").toString()
        return userDob
    }
    //sharing the result user name and lucky number
    @SuppressLint("QueryPermissionsNeeded")
    fun sharingData(name: String, Dob:String,quote:String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hey $name now know about his fortune")
        intent.putExtra(Intent.EXTRA_TEXT, "Here this is for you:- $quote")

        // Verify that there is an activity to handle the intent
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "No suitable app found to handle the intent", Toast.LENGTH_SHORT).show()
        }
    }
    fun getRandomQuote(): String {
        val inspirationalQuotes = listOf(
            "In the tapestry of time, each individual is a unique thread weaving a story of endless possibilities.",
            "The future holds a canvas of dreams, waiting for you to paint it with the vibrant colors of your aspirations.",
            "Tomorrow's sunrise brings with it the promise of new opportunities and the chance to redefine your journey.",
            "Embrace the unknown, for within it lies the magic of discovering your untapped potential.",
            "Your destiny is a symphony of choices, and each decision orchestrates a melody that resonates with your soul.",
            "The universe conspires to unfold a tapestry of success, woven with your determination and resilience.",
            "Look forward with hope, as the future is a garden where the seeds of your ambitions bloom into reality.",
            "The stars above whisper tales of your future, promising a celestial dance of accomplishments.",
            "Your path ahead is paved with the stepping stones of growth and the blossoms of self-discovery.",
            "The script of your life is an epic tale, and each chapter unfolds with the promise of adventure and triumph.",
            "With each dawn, the universe unveils new chapters of your story, filled with serendipity and joy.",
            "You are the architect of your destiny, and the blueprint of your dreams is waiting to be realized.",
            "Every challenge is a stepping stone, leading you closer to the radiant future you are destined to embrace.",
            "The horizon of tomorrow is painted with the hues of your passion and the brushstrokes of your perseverance.",
            "In the book of time, your pages are filled with unwritten adventures, waiting to be penned with the ink of your courage and determination."
        )
        val randomIndex = Random.nextInt(inspirationalQuotes.size)
        return inspirationalQuotes[randomIndex]
    }
}