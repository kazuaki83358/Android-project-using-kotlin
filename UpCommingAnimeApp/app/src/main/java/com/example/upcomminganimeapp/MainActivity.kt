package com.example.upcomminganimeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.upcomminganimeapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val category = "upcoming"
        val apiKey = "5a6d533453msh9b6fd77c2b17ca4p172f6fjsn5fa039c49d51"
        val host = "myanimelist.p.rapidapi.com"
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://myanimelist.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeApiInterface::class.java)
         val retrofitData = retrofitBuilder.getUpComingAnime(category,apiKey,host)

        retrofitData.enqueue(object : Callback<UpComingAnime?> {
            override fun onResponse(
                call: Call<UpComingAnime?>,
                response: Response<UpComingAnime?>
            ) {
                var responseBody = response.body()
                val title = responseBody?.get(0)?.title
                binding.tv.text = title
            }

            override fun onFailure(call: Call<UpComingAnime?>, t: Throwable) {
                Log.d("Main Activity","onFailure :"+t.message)
            }
        })
    }
}