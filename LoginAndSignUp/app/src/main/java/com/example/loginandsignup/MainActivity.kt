package com.example.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginandsignup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.backBtn.setOnClickListener(){
            Intent(this,WelcomeActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
        binding.reSignup.setOnClickListener(){
            Intent(this,SignUpActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}