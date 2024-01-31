package com.example.animeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@Suppress("DEPRECATION")
class AnimeAdapter(var animeList: List<Data>) : RecyclerView.Adapter<AnimeAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        var animeImage : ImageView
        var animeName : TextView
        init {
            animeImage = itemView.findViewById(R.id.anime_img)
            animeName = itemView.findViewById(R.id.anime_name)
            itemView.setOnClickListener{
                Toast.makeText(itemView.context,animeList[adapterPosition].title, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_anime,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val topAnime = animeList[position]
        holder.animeName.text = topAnime.title


        Glide.with(holder.itemView.context)
            .load(topAnime.images.jpg.image_url)  // Accessing the JPG image URL
            .into(holder.animeImage)
    }
}