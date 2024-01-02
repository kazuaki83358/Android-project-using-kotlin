package com.example.explicit_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn : Button = findViewById(R.id.Button)
        btn.setOnClickListener{
            var i : Intent = Intent(this,MainActivity2::class.java)

            //passing data between activities
            i.putExtra("age",19)
            startActivity(i)
        }
    }
}