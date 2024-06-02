package com.example.parcial_tp3_grupo_g3.holders

import android.media.Image
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcial_tp3_grupo_g3.R

class TripHolder(v : View): RecyclerView.ViewHolder(v){
    private var view : View

    init {
        this.view = v
    }

    fun setTripPrice(price: Double?){

        val itemPrice = view.findViewById<TextView>(R.id.item_trip_price)
        itemPrice.text = "$"+price.toString()
    }

    fun setNameAirline(airlineName: String?){
        val itemAirlineName = view.findViewById<TextView>(R.id.item_trip_nameAirline)
        itemAirlineName.text = airlineName
    }

    fun setLogoAirline(logo: String?){
        val itemAirlineLogo = view.findViewById<ImageView>(R.id.item_trip_airlineLogo)
        Glide.with(view.context).load(logo).centerInside().into(itemAirlineLogo)
    }

    fun setTime(time: Int?){
        val hours = time?.div(60) // obtén las horas dividiendo por 60
        val minutes = time?.rem(60) // obtén los minutos tomando el módulo de 60
        val time = String.format("%02dhr %02dmin", hours, minutes)
        val itemTime = view.findViewById<TextView>(R.id.item_trip_time)
        itemTime.text = time
    }

    fun setAirportID(airportID: String?){
        val itemAirportID = view.findViewById<TextView>(R.id.item_trip_txt_idAirport)
        itemAirportID.text = airportID
    }

    fun setAirportID2(airportID: String?){
        val itemAirportID = view.findViewById<TextView>(R.id.item_trip_txt_idAirport2)
        itemAirportID.text = airportID
    }

    fun setAirportName(airportName: String?){
        val itemAirportName = view.findViewById<TextView>(R.id.item_trip_txt_nameAirport)
        itemAirportName.text = airportName
    }

    fun setAirportName2(airportName: String?){
        val itemAirportName = view.findViewById<TextView>(R.id.item_trip_txt_nameAirport2)
        itemAirportName.text = airportName
    }

    fun setClass(classType: String?){
        val itemClass = view.findViewById<TextView>(R.id.item_trip_classText)
        itemClass.text = classType
    }

    fun viewDetails() = view.findViewById<Button>(R.id.itemTripButtonDetails)


}