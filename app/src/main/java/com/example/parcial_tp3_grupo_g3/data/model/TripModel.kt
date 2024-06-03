package com.example.parcial_tp3_grupo_g3.data.model

import com.example.parcial_tp3_grupo_g3.data.database.entities.FlightEntity
import com.example.parcial_tp3_grupo_g3.data.database.entities.TripEntity
import com.google.gson.annotations.SerializedName

data class TripModel(
    val flights: List<Flight>,
    @SerializedName("total_duration") val totalDuration: Int,
    @SerializedName("price") val price: Double,
    @SerializedName("departure_token") val departureToken: String,
    @SerializedName("type") val type: String
)

fun TripModel.toDomain() = TripModel(flights, totalDuration, price, departureToken, type)

//fun TripModel.toEntities(tripId: Long): TripEntity {
//   return TripEntity(
//        tripID = tripId,
//        totalDuration = this.totalDuration,
//        price = this.price
//    )
//}