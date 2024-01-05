package com.example.fun_project2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Adding items in an immutable list
        val items = listOf(
            ListItem("Item 1"),
            ListItem("Item 2"),
            ListItem("Item 3"),
            ListItem("Item 4"),
            ListItem("Item 5"),
            ListItem("Item 6"),
            ListItem("Item 7"),
            ListItem("Item 8"),
            ListItem("Item 9")

        )

        // Get the RecyclerView from the layout
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        // Create an instance of MyAdapter and pass the list of items
        val adapter = MyAdapter(items)

        // Set the layout manager for the RecyclerView (LinearLayoutManager in this case)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set the adapter for the RecyclerView
        recyclerView.adapter = adapter
    }
}
