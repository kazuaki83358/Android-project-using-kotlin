package com.example.animeapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animeapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //recycle view1
        recyclerView = findViewById(R.id.recycleView)
        val layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,
            false)
        recyclerView.layoutManager = layoutManager
        val animeList: ArrayList<Data> = ArrayList()
        val adapter = AnimeAdapter(animeList)
        recyclerView.adapter = adapter
        recyclerView.adapter = adapter
        getTopAnime()
    }

    private fun getTopAnime() {
        val retrofit = createRetrofit()
        val animeInterface = retrofit.create(AnimeInterface::class.java)
        val call = animeInterface.getTopAnime()
        call.enqueue(object : Callback<TopAnime> {
            override fun onResponse(call: Call<TopAnime>, response: Response<TopAnime>) {
                if (response.isSuccessful) {
                    val topAnime = response.body()?.data
                    if (topAnime.isNullOrEmpty()) {
                        // Handle empty response
                        Log.e("MainActivity", "Empty response body")
                    } else {
                        // Handle successful response
                        val top = response.body()!!.data
                        updateAdapter(top)
                    }
                } else {
                    // Handle error response
                    Log.e("MainActivity", "Error: ${response.code()}")
                    // Add more specific error handling based on HTTP status codes if needed
                }
            }

            override fun onFailure(call: Call<TopAnime>, t: Throwable) {
                // Handle failure
                Log.e("MainActivity", "Failed to retrieve data: ${t.message}")
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateAdapter(data: List<Data>) {
        val adapter = recyclerView.adapter as? AnimeAdapter
        adapter?.animeList = data
        adapter?.notifyDataSetChanged()
    }
    private fun createRetrofit(): Retrofit {
        val BASE_URL = "https://api.jikan.moe/v4/"
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}