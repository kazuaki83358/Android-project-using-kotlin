package com.example.memeapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("gimme")
    fun getData():Call<responnseDataClass>
}