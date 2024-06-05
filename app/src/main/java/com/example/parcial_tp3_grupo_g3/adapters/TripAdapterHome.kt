package com.example.parcial_tp3_grupo_g3.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.domain.model.Trip
import com.example.parcial_tp3_grupo_g3.holders.TripHolder
import com.example.parcial_tp3_grupo_g3.holders.TripHolderHome
import kotlin.random.Random


class TripAdapterHome(
    var tripList : MutableList<Trip>,

) : RecyclerView.Adapter<TripHolderHome>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripHolderHome {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lay_item_trip_home, parent, false)
        return TripHolderHome(view)
    }

    override fun onBindViewHolder(holder: TripHolderHome, position: Int) {
        val trip = tripList[position]
        //aca se hardcodeo este vuelo en especifico para que muestre un detalle diferente en el home
        //en realidad deberia ir para mostrar el destino que corresponda: trip.flights[trip.flights.size-1].arrival_airport.name
        holder.setTripDestinationName(trip.flights[0].departure_airport.name)
        holder.setTripDestinationImage(trip.image)

    }



    override fun getItemCount() = tripList.size


    fun updateList(newList: MutableList<Trip>) {
        tripList = newList.toMutableList()
        notifyDataSetChanged()
    }


}