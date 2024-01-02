package com.example.lucky_number_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Declaring the layout
        val textView1 : TextView = findViewById(R.id.textView1)
        var editText : EditText = findViewById(R.id.edit_text_id)
        val btn1 : Button = findViewById(R.id.btn1)

        btn1.setOnClickListener(){
            var name : String = editText.text.toString()
            //Explicit Intent
            var i = Intent(this,Activity2::class.java)
            i.putExtra("name",name)
            startActivity(i)
        }
    }
}