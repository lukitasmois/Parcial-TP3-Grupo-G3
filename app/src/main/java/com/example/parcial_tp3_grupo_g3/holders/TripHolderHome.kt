package com.example.parcial_tp3_grupo_g3.holders

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.domain.model.Trip
import com.example.parcial_tp3_grupo_g3.listeners.ItemClickListener

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

    fun setTripClass(tripClass: String){
        val itemClass = view.findViewById<TextView>(R.id.item_trip_home_class)
        itemClass.text = "$ $tripClass"
    }

     fun navigateToTripDetails() = view.findViewById<CardView>(R.id.item_trip_home_card)
}