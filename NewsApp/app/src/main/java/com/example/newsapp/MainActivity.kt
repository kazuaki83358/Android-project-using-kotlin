package com.example.newsapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val baseUrl = "https://newsapi.org/v2/"
    private val apiKey = "82492ad0265b4190b57f5dd05cb0cac2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val myApiInterface = retrofit.create(MyApiInterface::class.java)

        // Example search parameters
        val call = myApiInterface.getEverything(
            apiKey = apiKey,
            query = "bitcoin",
            sortBy = "publishedAt",
            pageSize = 5,
            language = "en"
        )
        call.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    val newsResponse: NewsResponse? = response.body()

                    // Assuming you want to display the title of the first article
                    if (newsResponse != null && newsResponse.articles.isNotEmpty()) {
                        val title: TextView = findViewById(R.id.title)
                        title.text = newsResponse.articles[0].title
                    }
                } else {
                    // Handle error
                    Log.e("MainActivity", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                // Handle failure
                Log.e("MainActivity", "Failed to retrieve data: ${t.message}")
            }
        })
    }
}
