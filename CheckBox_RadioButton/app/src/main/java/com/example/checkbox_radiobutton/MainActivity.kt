package com.example.checkbox_radiobutton

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //text view
        val textView :TextView = findViewById(R.id.textView3)
        //button
        val btn : Button = findViewById(R.id.Order)
        //checkbox
        val checkbox1: CheckBox = findViewById(R.id.checkbox1)
        val checkbox2: CheckBox = findViewById(R.id.checkbox2)
        val checkbox3: CheckBox = findViewById(R.id.checkbox3)
        //radio group
        val radio1: RadioButton = findViewById(R.id.burgger)
        val radio2: RadioButton = findViewById(R.id.pizza)
        val radio3: RadioButton = findViewById(R.id.momos)
        val radioGroup : RadioGroup = findViewById(R.id.food_selection)
        //Empty String
        var food = ""

        radio1.setOnClickListener{
            radio2.isChecked = false
            radio3.isChecked = false
            food = radio1.text.toString()
        }
        radio2.setOnClickListener{
            radio1.isChecked = false
            radio3.isChecked = false
            food = radio2.text.toString()
        }
        radio3.setOnClickListener{
            radio1.isChecked = false
            radio2.isChecked = false
            food = radio3.text.toString()
        }
        //button on click listener
        btn.setOnClickListener{
            // Get the state of each checkbox
            val isCheckedCheckbox1: Boolean = checkbox1.isChecked
            val isCheckedCheckbox2: Boolean = checkbox2.isChecked
            val isCheckedCheckbox3: Boolean = checkbox3.isChecked

            val selectedCheckBox = StringBuilder()

            if (isCheckedCheckbox1) {
                selectedCheckBox.append("Coco Cola ")
            }

            if (isCheckedCheckbox2) {
                selectedCheckBox.append("Pepsi ")
            }

            if (isCheckedCheckbox3) {
                selectedCheckBox.append("Fanta ")
            }

            val result = selectedCheckBox.toString().trim()
            textView.setText("Your order is :\n$food \n$result")
            //adding toast
            Toast.makeText(this,"Your order has been confirmed",Toast.LENGTH_LONG).show()
        }
    }

    }
