package com.example.fun_project2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val items: List<ListItem>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // Define the interface for click events
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position].text

        // Set click listener for each item
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
