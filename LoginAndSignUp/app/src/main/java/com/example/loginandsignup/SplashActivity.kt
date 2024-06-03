package com.example.loginandsignup

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.loginandsignup.databinding.ActivitySplashBinding
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        Handler().postDelayed({
            // Check if user is signed in (non-null) and update UI accordingly
            val currentUser = auth.currentUser
            if (currentUser != null) {
                // User is signed in, navigate to HomeActivity
                Intent(this, HomeActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            } else {
                // No user is signed in, navigate to WelcomeActivity
                Intent(this, WelcomeActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }, 3000)
    }
}
