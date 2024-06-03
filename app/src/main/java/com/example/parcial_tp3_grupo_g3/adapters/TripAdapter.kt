package com.example.parcial_tp3_grupo_g3.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.domain.model.Trip
import com.example.parcial_tp3_grupo_g3.holders.TripHolder
import com.example.parcial_tp3_grupo_g3.listeners.ItemClickListener

class TripAdapter(
    var tripList : MutableList<Trip>,
    val onItemClick : ItemClickListener
    ) : RecyclerView.Adapter<TripHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.lay_item_trip, parent, false)
            return TripHolder(view)
        }

        override fun onBindViewHolder(holder: TripHolder, position: Int) {
            val trip = tripList[position]
            holder.setTripPrice(trip.price)
            holder.setNameAirline(trip.flights[0].airlineName)
            holder.setLogoAirline(trip.flights[0].airlineLogo)
            holder.setTime(trip.totalDuration)
            holder.setAirportID(trip.flights[0].departure_airport.id)
            holder.setAirportID2(trip.flights[0].arrival_airport.id)
            holder.setAirportName(trip.flights[0].departure_airport.name)
            holder.setAirportName2(trip.flights[0].arrival_airport.name)
            holder.setClass(trip.flights[0].travelClass)
            holder.viewDetails().setOnClickListener {
                onItemClick.navigateToTripDetails(trip)
            }
        }

        override fun getItemCount() = tripList.size

        fun updateList(newList: MutableList<Trip>) {
            tripList = newList.toMutableList()
            notifyDataSetChanged()
        }
}