package com.example.calculator_using_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator_using_kotlin.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

@Suppress("unused")
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //clear
        binding.delete.setOnClickListener{
            deleteLastCharacter()
        }
        //all clear
        binding.AC.setOnClickListener{
            binding.inputText.text = ""
            binding.outputText.text = ""
        }
        //zero
        binding.zero.setOnClickListener{
            binding.inputText.append("0")
        }
        //double zero
        binding.doubleZero.setOnClickListener{
            binding.inputText.append("00")
        }
        //one
        binding.one.setOnClickListener{
            binding.inputText.append("1")
        }
        //two
        binding.two.setOnClickListener{
            binding.inputText.append("2")
        }
        //three
        binding.three.setOnClickListener{
            binding.inputText.append("3")
        }
        //four
        binding.four.setOnClickListener{
            binding.inputText.append("4")
        }
        //five
        binding.five.setOnClickListener{
            binding.inputText.append("5")
        }
        //six
        binding.six.setOnClickListener{
            binding.inputText.append("6")
        }
        //seven
        binding.seven.setOnClickListener{
            binding.inputText.append("7")
        }
        //eight
        binding.eight.setOnClickListener{
            binding.inputText.append("8")
        }
        //nine
        binding.nine.setOnClickListener{
            binding.inputText.append("9")
        }
        //dot
        binding.dot.setOnClickListener{
            binding.inputText.append(".")
        }
        //add
        binding.add.setOnClickListener{
            binding.inputText.append("+")
        }
        //subtract
        binding.subtract.setOnClickListener{
            binding.inputText.append("-")
        }
        //multiply
        binding.multiply.setOnClickListener{
            binding.inputText.append("*")
        }
        //divide
        binding.divide.setOnClickListener{
            binding.inputText.append("/")
        }
        //equal
        binding.equal.setOnClickListener{
            val expression = ExpressionBuilder(binding.inputText.text.toString()).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result==longResult.toDouble()){
                binding.outputText.text = longResult.toString()
            }else{
                binding.outputText.text = result.toString()
            }
        }
    }
    private fun deleteLastCharacter() {
        val currentInput = binding.inputText.text.toString()
        if (currentInput.isNotEmpty()) {
            val newInput = currentInput.substring(0, currentInput.length - 1)
            binding.inputText.text = newInput
        }
    }
}
