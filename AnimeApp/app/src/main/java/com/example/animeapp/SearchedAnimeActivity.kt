package com.example.animeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SearchedAnimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searched_anime)
        val homeBtn : Button = findViewById(R.id.homeBtn)
        val homeText : TextView = findViewById(R.id.textView)
        homeBtn.setOnClickListener{
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
        homeText.setOnClickListener{
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        finish()
    }
}