package com.example.lovecalculatorretrofitapi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculatorretrofitapi.databinding.ActivityResultBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale

class ResultActivity : AppCompatActivity() {
    private val binding: ActivityResultBinding by lazy {
        ActivityResultBinding.inflate(layoutInflater)
    }

    private val baseUrl = "https://love-calculator.p.rapidapi.com"
    private val apiKey = "5a6d533453msh9b6fd77c2b17ca4p172f6fjsn5fa039c49d51"
    private val host = "love-calculator.p.rapidapi.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val loveApi = retrofit.create(ApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val name1 = intent.getStringExtra("name1")
        val name2 = intent.getStringExtra("name2")

        if (name1 != null && name2 != null) {
            // Proceed only if both name1 and name2 are not null

            binding.textView1.text = name1.uppercase(Locale.getDefault())
            binding.textView3.text = name2.uppercase(Locale.getDefault())

            // Make a network request using Retrofit
            loveApi.getLovePercentage(name1, name2, apiKey, host)
                .enqueue(object : Callback<LoveResponse> {
                    override fun onResponse(
                        call: Call<LoveResponse>,
                        response: Response<LoveResponse>
                    ) {
                        if (response.isSuccessful) {
                            val loveResponse = response.body()
                            if (loveResponse != null) {
                                updateUI(loveResponse)
                            }
                        }
                    }

                    override fun onFailure(call: Call<LoveResponse>, t: Throwable) {
                        t.printStackTrace()
                    }
                })

            binding.calculateAgain.setOnClickListener {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI(loveResponse: LoveResponse) {
        // Update UI on the main thread
        runOnUiThread {
            binding.percent.text = "${loveResponse.percentage}%"
            binding.result.text = loveResponse.result
        }
    }
}
