package com.example.view_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.view_binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val textview : TextView = findViewById(R.id.textView)
        binding.textView.setOnClickListener(){
            binding.textView.text = "Thank You"
        }
        YoYo.with(Techniques.RubberBand)
            .duration(1000)
            .repeat(1)
            .playOn(textview)
    }
}