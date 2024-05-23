package com.example.blackcoffer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class Tab1Fragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PersonAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)

        // Create and set up adapter
        adapter = PersonAdapter(generateRandomData())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
    fun generateRandomData(): List<Person> {
        val random = Random.Default
        val names = arrayOf("Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack")
        val addresses = arrayOf("123 Main St", "456 Elm St", "789 Oak St", "101 Pine St", "202 Maple St")
        val data = mutableListOf<Person>()
        repeat(15) {
            val name = names[random.nextInt(names.size)]
            val address = addresses[random.nextInt(addresses.size)] // Fix typo here
            data.add(Person(name, address))
        }
        return data
    }
}
