package com.example.parcial_tp3_grupo_g3.domain.model

import android.os.Parcel
import android.os.Parcelable


data class Trip(
    val flights: List<Flight>,
    val totalDuration: Int,
    val price: Double,
    val tripID: String,
    val departureToken: String,
    val type: String,
    val image : String,
    var isSaved: Boolean = false,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(Flight.CREATOR)!!,
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(flights)
        parcel.writeInt(totalDuration)
        parcel.writeDouble(price)
        parcel.writeString(tripID)
        parcel.writeString(departureToken)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Trip> {
        override fun createFromParcel(parcel: Parcel): Trip {
            return Trip(parcel)
        }

        override fun newArray(size: Int): Array<Trip?> {
            return arrayOfNulls(size)
        }
    }
}




