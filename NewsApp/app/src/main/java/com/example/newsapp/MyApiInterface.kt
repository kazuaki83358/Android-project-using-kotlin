package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApiInterface {
    @GET("everything")
    fun getEverything(
        @Query("apiKey") apiKey: String,
        @Query("q") query: String,
        @Query("sortBy") sortBy: String,
        @Query("pageSize") pageSize: Int,
        @Query("language") language: String = "en"  // Default language is English
    ): Call<NewsResponse>
}
