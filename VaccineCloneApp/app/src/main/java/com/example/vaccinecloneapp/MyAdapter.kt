package com.example.vaccinecloneapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

@Suppress("unused", "DEPRECATION")
class MyAdapter(private val vaccinesList : ArrayList<DataModuleClass>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    @SuppressLint("ShowToast")
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var vaccineImg : ImageView
        var vaccineTitle :TextView
        init {
            vaccineImg = itemView.findViewById(R.id.img)
            vaccineTitle = itemView.findViewById(R.id.title)
            itemView.setOnClickListener{
                Toast.makeText(itemView.context,"You Choose: ${vaccinesList[adapterPosition].title}",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
       return vaccinesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.vaccineImg.setImageResource(vaccinesList[position].img)
        holder.vaccineTitle.text = vaccinesList[position].title
    }
}