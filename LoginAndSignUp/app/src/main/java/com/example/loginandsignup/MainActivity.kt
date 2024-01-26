package com.example.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginandsignup.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //initialize firebase auth
        auth = FirebaseAuth.getInstance()
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
        binding.loginToHome.setOnClickListener{
            var email = binding.emailId.text.toString()
            var password = binding.enterPassword.text.toString()
            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(this,"pleasse fill all the details",Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(){task->
                        if (task.isSuccessful){
                            Toast.makeText(this,"Sign In Successfully",Toast.LENGTH_SHORT).show()
                            Intent(this,HomeActivity::class.java).also {
                                startActivity(it)
                                finish()
                            }
                        }else{
                            Toast.makeText(this,"Sign Failed ${task.exception?.message}",Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}