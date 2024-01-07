package com.example.recycle_view_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val dataList: List<MyDataModel> = mutableListOf(
        MyDataModel(R.drawable.a, "Nishant kumar", "8851807684"),
        MyDataModel(R.drawable.b, "Nikhil Kumar", "4654646488"),
        MyDataModel(R.drawable.c, "Nandini", "2656544688"),
        MyDataModel(R.drawable.d, "Nihal kumar", "988465461"),
        MyDataModel(R.drawable.e, "Kashish", "9846451321"),
        MyDataModel(R.drawable.f, "Yash", "87946515132"),
        MyDataModel(R.drawable.g, "Jadu", "879125487"),
        MyDataModel(R.drawable.h, "John wick", "748596415263"),
        MyDataModel(R.drawable.a, "Nishant kumar", "8851807684"),
        MyDataModel(R.drawable.b, "Nikhil Kumar", "4654646488"),
        MyDataModel(R.drawable.c, "Nandini", "2656544688"),
        MyDataModel(R.drawable.d, "Nihal kumar", "988465461"),
        MyDataModel(R.drawable.e, "Kashish", "9846451321"),
        MyDataModel(R.drawable.f, "Yash", "87946515132"),
        MyDataModel(R.drawable.g, "Jadu", "879125487"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //declare recycler view
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this) // You can use other layout managers as well
        val adapter = MyAdapter(dataList)
        recyclerView.adapter = adapter

    }
}