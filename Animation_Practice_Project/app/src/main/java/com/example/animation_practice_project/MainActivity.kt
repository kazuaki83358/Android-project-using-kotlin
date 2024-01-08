package com.example.animation_practice_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView : TextView = findViewById(R.id.textView)
        val btn : Button = findViewById(R.id.btn)
        btn.setOnClickListener(){
            YoYo.with(Techniques.RubberBand)
                .duration(700)
                .playOn(textView)
        }
    }
}