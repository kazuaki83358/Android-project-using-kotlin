package com.example.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginandsignup.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
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
        binding.reLogin.setOnClickListener(){
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}