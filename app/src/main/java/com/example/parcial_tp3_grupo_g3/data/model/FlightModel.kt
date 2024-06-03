package com.example.parcial_tp3_grupo_g3.data.model

import com.example.parcial_tp3_grupo_g3.data.database.entities.AirportEntity
import com.example.parcial_tp3_grupo_g3.data.database.entities.FlightEntity
import com.example.parcial_tp3_grupo_g3.domain.model.Airport
import com.google.gson.annotations.SerializedName

data class Flight(
    val departure_airport : AirportModel,
    val arrival_airport : AirportModel,
    @SerializedName("airline") val airlineName: String,
    @SerializedName("airline_logo") val airlineLogo: String,
    @SerializedName("travel_class") val travelClass: String,
)

fun Flight.toAirportEntities(): List<AirportEntity> {
    return listOf(
        AirportEntity(
            id = this.departure_airport.id,
            name = this.departure_airport.name,
            time = this.departure_airport.time
        ),
        AirportEntity(
            id = this.arrival_airport.id,
            name = this.arrival_airport.name,
            time = this.arrival_airport.time
        )
    )
}


