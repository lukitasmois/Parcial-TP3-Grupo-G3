package com.example.parcial_tp3_grupo_g3.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcial_tp3_grupo_g3.R

class TripHolderHome(v : View): RecyclerView.ViewHolder(v) {
    private var view : View

    init {
        this.view = v
    }

    fun setTripDestinationName(name: String?){
        val nameFormat = name?.split(" ")?.first()
        val itemName = view.findViewById<TextView>(R.id.item_trip_home_destinationName)
        itemName.text = nameFormat
    }

    fun setTripDestinationImage(image: String){
        val Itemimage : ImageView = view.findViewById((R.id.item_trip_home_image))
        Glide.with(view.context).load(image).centerInside().into(Itemimage)
    }
}