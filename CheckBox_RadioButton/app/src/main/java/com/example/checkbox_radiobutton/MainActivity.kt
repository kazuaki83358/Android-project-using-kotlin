package com.example.checkbox_radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        var CheckBox1 : CheckBox = findViewById(R.id.checkbox1)
        var CheckBox2 : CheckBox = findViewById(R.id.checkbox2)
        var CheckBox3 : CheckBox = findViewById(R.id.checkbox3)
        val Text_View : TextView = findViewById(R.id.textView3)
        val Confirm_Order : Button = findViewById(R.id.Order)
        val RadioGroup : RadioGroup = findViewById(R.id.food_selection)
        val Burgger : RadioButton = findViewById(R.id.burgger)
        val Pizza : RadioButton = findViewById(R.id.pizza)
        val Momos : RadioButton = findViewById(R.id.momos)
        var Food = ""
        var Drink = ""
        //working with radio group
        Pizza.setOnClickListener {
            Burgger.isChecked = false
            Momos.isChecked = false
            Food = " Pizza "
        }
        Momos.setOnClickListener(){
            Burgger.isChecked = false
            Pizza.isChecked = false
            Food = " Momos "
        }
        Burgger.setOnClickListener(){
            Pizza.isChecked = false
            Momos.isChecked = false
            Food = " burgger "
        }
        //taking order and displaying order after clicking confirm order
        Confirm_Order.setOnClickListener {
            Toast.makeText(this,"Your order has been confirmed ",Toast.LENGTH_LONG).show()
        }

    }
}