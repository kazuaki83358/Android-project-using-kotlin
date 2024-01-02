package com.example.implicit_app

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn : Button = findViewById(R.id.btn)
        btn.setOnClickListener(){
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://developer.android.com/jetpack/compose/layouts/constraintlayout"))
            startActivity(intent)
        }
    }
}