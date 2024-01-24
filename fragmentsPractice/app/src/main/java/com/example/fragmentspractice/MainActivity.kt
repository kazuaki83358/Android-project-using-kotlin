package com.example.fragmentspractice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 : Button = findViewById(R.id.btn1)
        val btn2 : Button = findViewById(R.id.btn2)
        //button on click listener
        btn1.setOnClickListener(){
            val fragment1 : Fragment = fragment1()
            val frtrans : FragmentTransaction =
                supportFragmentManager.beginTransaction()
            frtrans.replace(R.id.frameLayout1,
                fragment1).commit()
        }
        btn2.setOnClickListener(){
            val fragment2 : Fragment = fragment2()
            val frtrans : FragmentTransaction =
                supportFragmentManager.beginTransaction()
            frtrans.replace(R.id.frameLayout2,
                fragment2).commit()
        }
    }
}