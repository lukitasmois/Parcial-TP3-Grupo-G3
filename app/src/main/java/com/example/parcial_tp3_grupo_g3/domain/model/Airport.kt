package com.example.parcial_tp3_grupo_g3.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.example.parcial_tp3_grupo_g3.data.database.entities.AirportEntity

data class Airport(
    val name : String,
    val id : String,
    val time : String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(id)
        parcel.writeString(time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Airport> {
        override fun createFromParcel(parcel: Parcel): Airport {
            return Airport(parcel)
        }

        override fun newArray(size: Int): Array<Airport?> {
            return arrayOfNulls(size)
        }
    }
}

fun Airport.toAirportEntity(): AirportEntity {
    return AirportEntity(
        id = this.id,
        name = this.name,
        time = this.time
    )
}