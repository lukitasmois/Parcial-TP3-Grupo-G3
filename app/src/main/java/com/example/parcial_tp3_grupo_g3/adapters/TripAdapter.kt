package com.example.parcial_tp3_grupo_g3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.domain.model.Trip
import com.example.parcial_tp3_grupo_g3.holders.TripHolder

class TripAdapter(
    var tripList : MutableList<Trip>,
    ) : RecyclerView.Adapter<TripHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.lay_item_trip, parent, false)
            return TripHolder(view)
        }

        override fun onBindViewHolder(holder: TripHolder, position: Int) {
            val trip = tripList[position]
            holder.setTripPrice(trip.price)
        }

        override fun getItemCount() = tripList.size

        fun updateList(newList: MutableList<Trip>) {
            tripList = newList.toMutableList()
            notifyDataSetChanged()
        }
}