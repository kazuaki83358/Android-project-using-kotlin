package com.example.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginandsignup.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignUpActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth
    override fun onStart() {
        super.onStart()
        val currentUser : FirebaseUser? = auth.currentUser
        if (currentUser!=null){
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //Initialize firebase auth
        auth = FirebaseAuth.getInstance()
        binding.backBtn.setOnClickListener {
            Intent(this,WelcomeActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
        binding.reLogin.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
        binding.register.setOnClickListener{
            val email = binding.signEmail.text.toString()
            val password = binding.signPasswordEnter.text.toString()
            val confirmPassword = binding.ConfirmPasswordEnter.text.toString()
            if (email.isEmpty()||password.isEmpty()||confirmPassword.isEmpty()){
                Toast.makeText(this,"Please fill all the details",Toast.LENGTH_SHORT).show()
            }
            else if (password != confirmPassword){
                Toast.makeText(this,"confirm password must be same",Toast.LENGTH_SHORT).show()
            }
            else{
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this){task->
                        if (task.isSuccessful){
                            Toast.makeText(this,"Registration is Successful",Toast.LENGTH_SHORT).show()
                            Intent(this,MainActivity::class.java).also {
                                startActivity(it)
                                finish()
                            }
                        }else{
                            Toast.makeText(this,"Registration is failed",Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}