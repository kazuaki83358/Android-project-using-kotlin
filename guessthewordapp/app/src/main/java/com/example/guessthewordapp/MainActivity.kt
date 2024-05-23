package com.example.guessthewordapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {
    // Declaring array of string
    internal var Days = arrayOf(
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday"
    )

    // Declaring variable for random
    lateinit var day: String
    lateinit var random: Random

    // Declaring variable for view
    lateinit var txtRightAnswer: TextView
    lateinit var txtQuestionContainer: TextView
    lateinit var txtCorrectAnswer: TextView
    lateinit var etUserInput: EditText
    lateinit var btnShow: Button
    lateinit var btnCheck: Button
    lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtRightAnswer = findViewById(R.id.right_textView)
        txtCorrectAnswer = findViewById(R.id.cr_TextView)
        txtQuestionContainer = findViewById(R.id.txtQuestionContainer)
        etUserInput = findViewById(R.id.etUserInput)
        btnShow = findViewById(R.id.btnShow)
        btnCheck = findViewById(R.id.btnCheck)
        btnNext = findViewById(R.id.btnNext)

        // Initialize the random variable
        random = Random()

        // Actual logic
        day = Days[random.nextInt(Days.size)]
        txtQuestionContainer.text = mixWord(day)

        // setOnClickListener
        btnCheck.setOnClickListener {
            if (etUserInput.text.toString().equals(day, ignoreCase = true)) {
                Toast.makeText(this,"you are right",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"you are wrong",Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Corrected mixWord function
    fun mixWord(word: String): String {
        val chars = word.toCharArray()
        chars.shuffle()
        return String(chars)
    }
}
