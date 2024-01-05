package com.example.fun_project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 : AppCompatButton = findViewById(R.id.btn1)
        btn1.setOnClickListener(){
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }
}