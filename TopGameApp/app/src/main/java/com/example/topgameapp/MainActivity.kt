package com.example.topgameapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Adapter : Recycle View
        var recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,
            false)
        //data source
        val gameList : ArrayList<GameModel> = ArrayList()
        val v1 =GameModel(R.drawable.card1,"Horizon Chase Turbo")
        val v2 =GameModel(R.drawable.card2,"Pubg")
        val v3 =GameModel(R.drawable.card3,"Head Ball 2")
        val v4 =GameModel(R.drawable.card4,"Hoked On You")
        val v5 =GameModel(R.drawable.card5,"Fifa Mobile 22")
        val v6 =GameModel(R.drawable.card6,"Fortnite")

        gameList.add(v1)
        gameList.add(v2)
        gameList.add(v3)
        gameList.add(v4)
        gameList.add(v5)
        gameList.add(v6)

        val adapter = MyAdapterClass(gameList)
        recyclerView.adapter = adapter

    }
}