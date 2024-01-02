package com.example.explicit_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //Receiving data
        val bundle : Bundle? = intent.extras
        val age = bundle?.get("age")
        //passing it to toast
        Toast.makeText(this, "your age is $age",Toast.LENGTH_LONG).show()
    }
}