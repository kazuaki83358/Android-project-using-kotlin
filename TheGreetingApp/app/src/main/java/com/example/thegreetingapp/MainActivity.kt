package com.example.thegreetingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var clickMe : Button = findViewById(R.id.clickme)
        var eti : EditText = findViewById(R.id.edit_text_id)

        clickMe.setOnClickListener(){
            val name = eti.text.toString()
            //get it in toast
            if (name.isEmpty()){
                Toast.makeText(this,"please enter your name than click me",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"hello $name",Toast.LENGTH_LONG).show()
            }

        }
    }
}