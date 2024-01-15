package com.example.worldcupapp

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

@Suppress("NAME_SHADOWING")
class MyAdapter(private var activity: Activity, private var items: ArrayList<countryModelClass>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): countryModelClass {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val holder: ViewHolder

        if (convertView == null) {
            val inflater = LayoutInflater.from(activity)
            convertView = inflater.inflate(R.layout.list_item, null)

            // Create a ViewHolder and store references to the child views
            holder = ViewHolder()
            holder.countryNameTextView = convertView.findViewById(R.id.country_name)
            holder.cupsCountTextView = convertView.findViewById(R.id.worldCup)
            holder.imageView = convertView.findViewById(R.id.flag)

            convertView.tag = holder
        } else {
            // If convertView is not null, reuse the ViewHolder
            holder = convertView.tag as ViewHolder
        }

        // Set data to the views
        val country = getItem(position)
        holder.countryNameTextView.text = country.countryName
        holder.cupsCountTextView.text = country.cupsWin.toString()
        // Assume that countryModelClass has a method to get the image resource ID
        holder.imageView.setImageResource(country.getImageResourceId())

        convertView?.setOnClickListener{
            Toast.makeText(activity,
                "you choose: ${country.countryName}",
                Toast.LENGTH_SHORT).show()
        }
        return convertView!!
    }

    // ViewHolder pattern to improve performance by caching references to views
    private class ViewHolder {
        lateinit var countryNameTextView: TextView
        lateinit var cupsCountTextView: TextView
        lateinit var imageView: ImageView
    }
}