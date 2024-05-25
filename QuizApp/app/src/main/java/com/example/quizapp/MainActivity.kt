package com.example.quizapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvQuestionCounter: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var ivQuestionImage: ImageView
    private lateinit var rgOptions: RadioGroup
    private lateinit var btnNext: Button

    private var currentQuestionIndex = 0

    private val questions = listOf(
        Question("What is the capital of France?", R.drawable.paris, listOf("Paris", "London", "Berlin", "Madrid"), "Paris"),
        Question("What is the capital of Spain?", R.drawable.madrid, listOf("Lisbon", "Madrid", "Rome", "Berlin"), "Madrid"),
        Question("What is the capital of Italy?", R.drawable.rome, listOf("Rome", "Venice", "Milan", "Naples"), "Rome"),
        Question("What is the capital of Germany?", R.drawable.berlin, listOf("Berlin", "Munich", "Frankfurt", "Hamburg"), "Berlin"),
        Question("What is the capital of Portugal?", R.drawable.lisbon, listOf("Lisbon", "Porto", "Braga", "Coimbra"), "Lisbon"),
        Question("What is the capital of Greece?", R.drawable.athens, listOf("Athens", "Thessaloniki", "Patras", "Heraklion"), "Athens"),
        Question("What is the capital of the UK?", R.drawable.london, listOf("London", "Manchester", "Liverpool", "Birmingham"), "London"),
        Question("What is the capital of the USA?", R.drawable.washington_dc, listOf("Washington, D.C.", "New York", "Los Angeles", "Chicago"), "Washington, D.C."),
        Question("What is the capital of Canada?", R.drawable.ottawa, listOf("Ottawa", "Toronto", "Vancouver", "Montreal"), "Ottawa")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvQuestionCounter = findViewById(R.id.tvQuestionCounter)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivQuestionImage = findViewById(R.id.ivQuestionImage)
        rgOptions = findViewById(R.id.rgOptions)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {
            val selectedOptionId = rgOptions.checkedRadioButtonId
            if (selectedOptionId != -1) {
                val selectedOption = findViewById<RadioButton>(selectedOptionId)
                val correctAnswer = questions[currentQuestionIndex].correctAnswer
                if (selectedOption.text == correctAnswer) {
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Incorrect. The correct answer is $correctAnswer", Toast.LENGTH_SHORT).show()
                }

                if (currentQuestionIndex < questions.size - 1) {
                    currentQuestionIndex++
                    loadQuestion(currentQuestionIndex)
                } else {
                    // Handle quiz completion
                    Toast.makeText(this, "Quiz completed!", Toast.LENGTH_SHORT).show()
                    currentQuestionIndex = 0
                    loadQuestion(currentQuestionIndex)
                }
            } else {
                Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show()
            }
        }

        loadQuestion(currentQuestionIndex)
    }

    @SuppressLint("SetTextI18n")
    private fun loadQuestion(index: Int) {
        val question = questions[index]
        tvQuestion.text = question.text
        ivQuestionImage.setImageResource(question.imageResId)
        rgOptions.clearCheck()

        for (i in 0 until rgOptions.childCount) {
            (rgOptions.getChildAt(i) as RadioButton).text = question.options[i]
        }

        tvQuestionCounter.text = "Question ${index + 1} of ${questions.size}"
    }

    data class Question(
        val text: String,
        val imageResId: Int,
        val options: List<String>,
        val correctAnswer: String
    )
}
