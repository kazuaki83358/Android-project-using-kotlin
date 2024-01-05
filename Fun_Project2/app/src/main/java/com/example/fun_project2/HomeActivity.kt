package com.example.fun_project2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {

    // Declare items as a property of the HomeActivity class
    private val items = listOf(
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
            // Add more cases for other items if needed
            else -> intent.putExtra("selected_item", "Default Text")
        }

        startActivity(intent)
    }

}
