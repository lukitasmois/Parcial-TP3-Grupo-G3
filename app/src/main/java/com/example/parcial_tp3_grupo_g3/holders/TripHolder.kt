package com.example.parcial_tp3_grupo_g3.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3_grupo_g3.R

class TripHolder(v : View): RecyclerView.ViewHolder(v){
    private var view : View

    init {
        this.view = v
    }

    fun setTripPrice(price: Double?){
        val itemText = view.findViewById<TextView>(R.id.item_trip_price)
        itemText.text = price.toString()
    }
}