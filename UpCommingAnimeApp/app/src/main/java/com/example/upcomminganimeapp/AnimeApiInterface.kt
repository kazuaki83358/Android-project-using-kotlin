package com.example.upcomminganimeapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AnimeApiInterface {
    @GET("anime/top")
    fun getUpComingAnime(
        @Query("category") category : String = "upcoming",
        @Header("x-rapidapi-key") apiKey: String = "5a6d533453msh9b6fd77c2b17ca4p172f6fjsn5fa039c49d51",
        @Header("x-rapidapi-host") host: String = "myanimelist.p.rapidapi.com"
    ): Call<UpComingAnime>
}