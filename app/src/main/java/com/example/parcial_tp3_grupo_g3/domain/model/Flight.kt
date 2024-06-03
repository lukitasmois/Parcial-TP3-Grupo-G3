package com.example.parcial_tp3_grupo_g3.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.example.parcial_tp3_grupo_g3.data.database.entities.AirportEntity


data class Flight(
    val departure_airport : Airport,
    val arrival_airport : Airport,
    val airlineName: String,
    val airlineLogo: String,
    val travelClass: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Airport::class.java.classLoader)!!,
        parcel.readParcelable(Airport::class.java.classLoader)!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(departure_airport, flags)
        parcel.writeParcelable(arrival_airport, flags)
        parcel.writeString(airlineName)
        parcel.writeString(airlineLogo)
        parcel.writeString(travelClass)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Flight> {
        override fun createFromParcel(parcel: Parcel): Flight {
            return Flight(parcel)
        }

        override fun newArray(size: Int): Array<Flight?> {
            return arrayOfNulls(size)
        }
    }
}



