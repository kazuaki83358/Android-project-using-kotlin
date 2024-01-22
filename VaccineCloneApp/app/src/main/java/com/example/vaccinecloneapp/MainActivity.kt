package com.example.vaccinecloneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //AdapterView : RecyclerView
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,
            false)
        //Data source
        var vaccineList : ArrayList<DataModuleClass> = ArrayList()
        val v1 = DataModuleClass(R.drawable.vaccine1,"COVID-19")
        val v2 = DataModuleClass(R.drawable.vaccine2,"Hepatitis B Vaccine")
        val v3 = DataModuleClass(R.drawable.vaccine3,"Tetanus Vaccine")
        val v4 = DataModuleClass(R.drawable.vaccine4,"Pneumococcal Vaccine")
        val v5 = DataModuleClass(R.drawable.vaccine5,"Rotavirus  Vaccine")
        val v6 = DataModuleClass(R.drawable.vaccine6,"Measles Vaccine")
        val v7 = DataModuleClass(R.drawable.vaccine7,"Chickenpox Vaccine")

        vaccineList.add(v1)
        vaccineList.add(v2)
        vaccineList.add(v3)
        vaccineList.add(v4)
        vaccineList.add(v5)
        vaccineList.add(v6)
        vaccineList.add(v7)

        //adapter
        val adapter = MyAdapter(vaccineList)
        recyclerView.adapter = adapter
    }
}