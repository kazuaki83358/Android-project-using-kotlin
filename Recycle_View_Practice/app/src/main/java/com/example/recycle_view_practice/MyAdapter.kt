package com.example.recycle_view_practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class MyAdapter(private val dataList : List<MyDataModel>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        val data = dataList[position]

        //set data to view
        holder.imageView.setImageResource(data.imageResourceId)
        holder.textView1.text = data.text1
        holder.textView2.text= data.text2
    }

    override fun getItemCount(): Int {
       return dataList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView1: TextView = itemView.findViewById(R.id.text_view1)
        val textView2: TextView = itemView.findViewById(R.id.text_view2)
    }
}