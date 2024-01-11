package com.example.weither_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.weither_app.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

//886705b4c1182eb1c69f28eb8c520e20

class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fetchWeatherData("delhi")
        searchCity()
    }

    private fun searchCity() {
        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    fetchWeatherData(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               return true
            }

        })
    }

    private fun fetchWeatherData(cityName:String) {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(apiInterface::class.java)
        val response = retrofit.getWeatherData(cityName,"886705b4c1182eb1c69f28eb8c520e20","metric")
        response.enqueue(object : Callback<wheatherApp>{
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<wheatherApp>, response: Response<wheatherApp>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null){
                    val temperature = responseBody.main.temp
                    val humidity = responseBody.main.humidity
                    val wind = responseBody.wind.speed
                    val max = responseBody.main.temp_max
                    val min = responseBody.main.temp_min
                    val condition = responseBody.weather.firstOrNull()?.main?:"unknown"
                    binding.temp.text= "$temperature °C"
                    binding.humidity.text = "$humidity %"
                    binding.wind.text = "$wind m/s"
                    binding.max.text = "Max : $max °C"
                    binding.min.text = "Min : $min °C"
                    binding.condition.text = condition
                    binding.day.text = dayName()
                    binding.city.text = cityName

                    changeAnimationWithWeather(condition)
                }
            }

            override fun onFailure(call: Call<wheatherApp>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun changeAnimationWithWeather(condition:String) {
        when(condition){
            "Clear Sky","Sunny","Clear" ->{
                binding.lottieAnimationView.setAnimation(R.raw.sun)
            }
            "Partly Clouds","Clouds","OverCast","Mist","Foggy","Haze","Smoke"->{
                binding.lottieAnimationView.setAnimation(R.raw.cloud)
            }
            "Light Rain","Drizzle","Moderate Rain","Showers","Heavy Rain"->{
                binding.lottieAnimationView.setAnimation(R.raw.rain)
            }
            "Light Snow","Moderate Snow","Blizzard","Heavy Snow"->{
                binding.lottieAnimationView.setAnimation(R.raw.snow)
            }
            else ->{
                binding.lottieAnimationView.setAnimation(R.raw.sun)
            }
        }
        binding.lottieAnimationView.playAnimation()
    }

    fun dayName():String{
        val sdf = SimpleDateFormat("EEEE", Locale.getDefault())
        return sdf.format((Date()))
    }
}