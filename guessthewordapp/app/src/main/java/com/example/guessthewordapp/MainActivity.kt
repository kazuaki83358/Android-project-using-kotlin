package com.example.guessthewordapp

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View
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

    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
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
              val dialog = Dialog(this@MainActivity)
                dialog.setContentView(R.layout.correct_dialog)
                val bthide = dialog.findViewById<Button>(R.id.btConfirmDialog)
                bthide.setOnClickListener {
                    dialog.dismiss()
                    day = Days[random.nextInt(Days.size)]
                    txtQuestionContainer.text = mixWord(day)
                    etUserInput.setText("")
                    txtCorrectAnswer.visibility = View.INVISIBLE
                    txtRightAnswer.visibility = View.INVISIBLE
                }
                dialog.show()
            } else {
                Toast.makeText(this,"you are wrong",Toast.LENGTH_SHORT).show()
            }
        }

        //set the listener for next button
        btnNext.setOnClickListener {
            day = Days[random.nextInt(Days.size)]
            txtQuestionContainer.text = mixWord(day)

            etUserInput.setText("")
            txtCorrectAnswer.visibility = View.INVISIBLE
            txtRightAnswer.visibility = View.INVISIBLE
        }

        //set the listener for show button
        btnShow.setOnClickListener {
            txtCorrectAnswer.visibility = View.VISIBLE
            txtRightAnswer.visibility = View.VISIBLE
            txtRightAnswer.text = day
        }
    }

    // Corrected mixWord function
    fun mixWord(word: String): String {
        val chars = word.toCharArray()
        chars.shuffle()
        return String(chars)
    }
}
