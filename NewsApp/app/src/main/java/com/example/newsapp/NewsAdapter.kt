package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(var articles: List<Article>, private val itemClickListener: (String) -> Unit) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]

        holder.title.text = article.title
        holder.description.text = article.description

        // Use a library like Glide to load images efficiently
        Glide.with(holder.itemView.context)
            .load(article.urlToImage)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            // Pass the URL to the item click listener
            itemClickListener(article.url)
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }
}

