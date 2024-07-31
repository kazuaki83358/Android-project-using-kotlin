package com.example.topgameapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class MyAdapterClass (var gameList: ArrayList<GameModel>):RecyclerView.Adapter<MyAdapterClass.MyViewHolder>(){
    inner class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
         var game_img : ImageView
         var game_title : TextView
        init {
            game_img = itemView.findViewById(R.id.image)
            game_title = itemView.findViewById(R.id.title)
            itemView.setOnClickListener{
                Toast.makeText(itemView.context,gameList[adapterPosition].title,Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val v = LayoutInflater.from(parent.context)
           .inflate(R.layout.game_item_list,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.game_img.setImageResource(gameList[position].img)
        holder.game_title.setText(gameList[position].title)
    }
}