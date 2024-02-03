package com.example.animeapp
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchedAnimeActivity : AppCompatActivity() {
    // Declare userSearchQuery as a class variable
    private var userSearchQuery: String = ""
    private lateinit var recyclerView3: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searched_anime)

        // Initialize userSearchQuery in onCreate
        userSearchQuery = ""
        recyclerView3 = findViewById(R.id.recycleView2)
        val layoutManager = GridLayoutManager(this,2)
        recyclerView3.layoutManager = layoutManager
        val animeList: ArrayList<Data> = ArrayList()
        val searchAdapter = AnimeAdapter(animeList)
        recyclerView3.adapter = searchAdapter
        val homeBtn: Button = findViewById(R.id.homeBtn)
        val homeText: TextView = findViewById(R.id.textView)

        homeBtn.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        homeText.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        val searchView: SearchView = findViewById(R.id.anime_search_bar)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            @SuppressLint("SetTextI18n")
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrBlank()) {
                    userSearchQuery = query
                    showSearchResults()
                    getSearchAnime()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun showSearchResults() {
        val searchResult: TextView = findViewById(R.id.search_result)
        searchResult.text = "Your Search Result"
    }

    private fun getSearchAnime() {
        val retrofit = createRetrofit()
        val animeInterface = retrofit.create(AnimeInterface::class.java)
        val call = animeInterface.getSearch(userSearchQuery)
        call.enqueue(object : Callback<SearchedAnime> {
            override fun onResponse(
                call: Call<SearchedAnime>,
                response: Response<SearchedAnime>
            ) {
                if (response.isSuccessful) {
                    val searchedAnime = response.body()?.data
                    if (searchedAnime.isNullOrEmpty()) {
                        Log.e("SearchedAnimeActivity", "Empty response body")
                    } else {
                        val upcoming = response.body()!!.data
                        // Assuming you have a function named updateUpcomingAdapter
                        // to handle updating the UI with the retrieved data
                        updateSearchAdapter(upcoming)
                    }
                } else {
                    Log.e("SearchedAnimeActivity", "Error: ${response.code()}")
                    // Handle specific error cases based on HTTP status codes if needed
                }
            }

            override fun onFailure(call: Call<SearchedAnime>, t: Throwable) {
                Log.e("SearchedAnimeActivity", "Failed to retrieve data: ${t.message}")
            }
        })
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun updateSearchAdapter(upcoming: List<Data>) {
        val adapter = recyclerView3.adapter as? AnimeAdapter
        adapter?.animeList = upcoming
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
