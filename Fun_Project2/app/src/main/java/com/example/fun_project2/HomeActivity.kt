package com.example.fun_project2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {

    // Declare items as a property of the HomeActivity class
    private val items = listOf(
        ListItem("Java Intro"),
        ListItem("Java Get Started"),
        ListItem(" Syntax"),
        ListItem("Java Output"),
        ListItem("Java Comments"),
        ListItem("Java Variables"),
        ListItem("Java Data Types"),
        ListItem("Java Type Casting"),
        ListItem("Java Operators"),
        ListItem("Java String"),
        ListItem("Java Math"),
        ListItem("Java Booleans")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Get the RecyclerView from the layout
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        // Create an instance of MyAdapter and pass the list of items
        val adapter = MyAdapter(items, this)

        // Set the layout manager for the RecyclerView (LinearLayoutManager in this case)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set the adapter for the RecyclerView
        recyclerView.adapter = adapter
    }

    // Implement the onItemClick method from the OnItemClickListener interface
    override fun onItemClick(position: Int) {
        val intent = Intent(this, SecondActivity::class.java)

        // Check which item is clicked and set the appropriate text in the Intent
        when (position) {
            0 -> intent.putExtra("selected_item", "Text for Item 1")
            1 -> intent.putExtra("selected_item", "Text for Item 2")
            2 -> intent.putExtra("selected_item", "Text for Item 3")
            3 -> intent.putExtra("selected_item", "Text for Item 4")
            4 -> intent.putExtra("selected_item", "Text for Item 5")
            5 -> intent.putExtra("selected_item", "Text for Item 6")
            6 -> intent.putExtra("selected_item", "Text for Item 7")
            7 -> intent.putExtra("selected_item", "Text for Item 8")
            8 -> intent.putExtra("selected_item", "Text for Item 9")
            9 -> intent.putExtra("selected_item", "Text for Item 10")
            10 -> intent.putExtra("selected_item", "Text for Item 11")
            11 -> intent.putExtra("selected_item", "Text for Item 13")
            // Add more cases for other items if needed
            else -> intent.putExtra("selected_item", "Default Text")
        }

        startActivity(intent)
    }

}

