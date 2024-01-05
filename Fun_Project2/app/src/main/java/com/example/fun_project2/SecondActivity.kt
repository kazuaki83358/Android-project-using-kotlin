package com.example.fun_project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Retrieve the data passed from HomeActivity
        val selectedItemText = intent.getStringExtra("selected_item")

        // Find the TextView in your layout
        val textView: TextView = findViewById(R.id.textView2)

        // Update the TextView with the selected item's text
        textView.text = selectedItemText
    }
}
