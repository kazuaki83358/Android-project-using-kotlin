package com.example.animeapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeInterface {
    @GET("top/anime")
    fun getTopAnime(
    ): Call<TopAnime>
    @GET("seasons/upcoming")
    fun getUpcomingAnime(
    ):Call<UpcomingAanime>
}