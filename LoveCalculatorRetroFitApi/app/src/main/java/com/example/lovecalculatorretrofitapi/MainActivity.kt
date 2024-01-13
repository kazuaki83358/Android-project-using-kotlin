package com.example.lovecalculatorretrofitapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lovecalculatorretrofitapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private val binding:ActivityMainBinding by lazy {
    ActivityMainBinding.inflate(layoutInflater)
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.calculate.setOnClickListener{
            if (binding.name1.text.isEmpty()||binding.name2.text.isEmpty()){
                Toast.makeText(this,"Please fill both blanks",Toast.LENGTH_LONG).show()
            }else{
                val name1 = binding.name1.text.toString()
                val name2 = binding.name2.text.toString()
                val i = Intent(this,ResultActivity::class.java)
                i.putExtra("name1",name1)
                i.putExtra("name2",name2)
                startActivity(i)
            }
        }
    }
}