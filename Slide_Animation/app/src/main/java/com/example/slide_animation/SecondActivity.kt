package com.example.slide_animation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btn2: Button = findViewById(R.id.btn2)
        btn2.setOnClickListener {
            val i = Intent(this, ThirdActivity::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right)
        }
    }
    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left)
    }
}
