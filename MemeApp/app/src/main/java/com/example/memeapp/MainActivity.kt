package com.example.memeapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.memeapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//https://meme-api.com/gimme
class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getData()
        binding.btn.setOnClickListener{
            getData()
        }
    }

    private fun getData() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait while data is fetch")
        progressDialog.show()
        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<responnseDataClass?> {
            override fun onResponse(
                call: Call<responnseDataClass?>,
                response: Response<responnseDataClass?>
            ) {
                Glide.with(this@MainActivity).load(response.body()?.url).into(binding.imageView2)
                progressDialog.dismiss()
            }

            override fun onFailure(call: Call<responnseDataClass?>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage,Toast.LENGTH_LONG).show()
                progressDialog.dismiss()
            }
        })
    }
}