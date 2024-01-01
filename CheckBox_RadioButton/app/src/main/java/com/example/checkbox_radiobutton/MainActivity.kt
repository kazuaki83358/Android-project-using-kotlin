package com.example.checkbox_radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView :TextView = findViewById(R.id.textView3)
        val btn : Button = findViewById(R.id.Order)
        val food_selection : RadioGroup = findViewById(R.id.food_selection)
        val coco_cola : CheckBox = findViewById(R.id.checkbox1)
        val pepsi : CheckBox = findViewById(R.id.checkbox2)
        val fanta : CheckBox = findViewById(R.id.checkbox3)
        btn.setOnClickListener{
            val checkedFoodRadioButtonId = food_selection.checkedRadioButtonId

            if (checkedFoodRadioButtonId != View.NO_ID) {
                val food = findViewById<RadioButton>(checkedFoodRadioButtonId)?.text ?: ""

                val drink1 = coco_cola.isChecked
                val drink2 = pepsi.isChecked
                val drink3 = fanta.isChecked

                val orderString = "You ordered:\n$food" +
                        (if (drink1) "\nCoco Cola" else "") +
                        (if (drink2) "\nPepsi" else "") +
                        (if (drink3) "\nFanta" else "")

                textView.text = orderString
            } else {
                Toast.makeText(this, "Please select a food item", Toast.LENGTH_SHORT).show()
            }
        }

    }

    }
