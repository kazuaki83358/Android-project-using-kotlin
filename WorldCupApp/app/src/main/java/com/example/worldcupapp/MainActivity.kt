package com.example.worldcupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Adapter view : List View
        var ListView = findViewById<ListView>(R.id.listView)
        //Adapter
        var adapter = MyAdapter(this,generateData())
        ListView?.adapter = adapter
        adapter?.notifyDataSetChanged()
    }
    //Data Source
    fun generateData():ArrayList<countryModelClass>{
        var result = ArrayList<countryModelClass>()
        var country1 : countryModelClass = countryModelClass(
            "India",
            "2",
            R.drawable.india
        )
        var country2 : countryModelClass = countryModelClass(
            "Australia",
            "6",
            R.drawable.australia
        )
        var country3 : countryModelClass = countryModelClass(
            "England",
            "1",
            R.drawable.england
        )
        var country4 : countryModelClass = countryModelClass(
            "New Zealand",
            "0",
            R.drawable.new_zeland
        )
        var country5 : countryModelClass = countryModelClass(
            "Pakistan",
            "1",
            R.drawable.pak
        )
        var country6 : countryModelClass = countryModelClass(
            "Sri Lanka",
            "1",
            R.drawable.sri_lanka
        )
        var country7 : countryModelClass = countryModelClass(
            "West Indies",
            "2",
            R.drawable.west_indies
        )
        result.add(country1)
        result.add(country2)
        result.add(country3)
        result.add(country4)
        result.add(country5)
        result.add(country6)
        result.add(country7)
        return result
    }
}