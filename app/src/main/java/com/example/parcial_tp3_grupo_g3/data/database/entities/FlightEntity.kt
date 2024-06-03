package com.example.parcial_tp3_grupo_g3.data.database.entities


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.parcial_tp3_grupo_g3.domain.model.Flight


@Entity(
    tableName = "flight",
    foreignKeys = [
        ForeignKey(
            entity = TripEntity::class,
            parentColumns = ["tripID"],
            childColumns = ["tripID"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class FlightEntity(
    @PrimaryKey var tripID: String,
    val airlineName: String,
    val airlineLogo: String,
    val travelClass: String,
    val departure_airport_id: String,
    val arrival_airport_id: String,
)

fun FlightEntity.toDomainModel(airports: Map<String, AirportEntity>): Flight {
    val departureAirport = airports[departure_airport_id] ?: throw IllegalStateException("Departure airport not found")
    val arrivalAirport = airports[arrival_airport_id] ?: throw IllegalStateException("Arrival airport not found")
    return Flight(
        departure_airport = departureAirport.toDomainModel(),
        arrival_airport = arrivalAirport.toDomainModel(),
        airlineName = airlineName,
        airlineLogo = airlineLogo,
        travelClass = travelClass
    )
}



