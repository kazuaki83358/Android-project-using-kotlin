package com.example.loginandsignup

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.example.loginandsignup.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val aninyuzText = "AniNyuz"
        val spanableString = SpannableString(aninyuzText)
        spanableString.setSpan(ForegroundColorSpan(Color.parseColor("#FFFFFF")),0,2,0)
        spanableString.setSpan(ForegroundColorSpan(Color.parseColor("#CA38ED")),2,spanableString.length,0)

        binding.ani.text = spanableString
        setContentView(binding.root)
        //login button use set
        binding.login.setOnClickListener(){
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }
        //signup button use set
        binding.signup.setOnClickListener(){
            Intent(this,SignUpActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}