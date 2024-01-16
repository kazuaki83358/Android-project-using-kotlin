package com.example.newsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val loadingIndicator: ProgressBar = findViewById(R.id.loadingIndicator)
        // Initialize RecyclerView and set its layout manager
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        // Initialize RecyclerView adapter
        val adapter = NewsAdapter(emptyList()) { url ->
            // Handle the click event here, for example, open the URL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        getData(adapter, loadingIndicator)
    }

    private fun getData(adapter: NewsAdapter, loadingIndicator: ProgressBar) {
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
            pageSize = 100,
            language = "en"
        )
        call.enqueue(object : Callback<NewsResponse> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    val newsResponse: NewsResponse? = response.body()

                    // Assuming you want to display the title of the first article
                    if (newsResponse != null && newsResponse.articles.isNotEmpty()) {
                        //if get response then what u have to do
                        // Update RecyclerView adapter data
                        adapter.articles = newsResponse.articles
                        adapter.notifyDataSetChanged()

                        // Hide loading indicator
                        loadingIndicator.visibility = View.GONE
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
