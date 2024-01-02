package com.example.fun_project_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //declaring layout
        var editText1 : TextView = findViewById(R.id.edit_text_id1)
        var editText2 : TextView = findViewById(R.id.edit_text_id2)
        val btn2 : Button = findViewById(R.id.btn2)
        var name = ""
        var dateOfBirth = ""
        btn2.setOnClickListener(){
            if (editText1.text.isEmpty()||editText2.text.isEmpty()){
                Toast.makeText(this,"Please fill All the requirements",Toast.LENGTH_LONG).show()
            }
            else{
                name = editText1.text.toString()
                dateOfBirth = editText2.text.toString()
                var i = Intent(this,ResultActivity::class.java)
                i.putExtra("name",name)
                i.putExtra("dob",dateOfBirth)
                startActivity(i)
            }
        }
    }
}