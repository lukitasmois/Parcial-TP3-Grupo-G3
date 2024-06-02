package com.example.parcial_tp3_grupo_g3.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.parcial_tp3_grupo_g3.domain.model.Trip

@Entity(tableName = "trips_table")
data class TripEntity(
    @PrimaryKey(autoGenerate = true)
    var tripID: Long = 0,
    val totalDuration: Int,
    val price: Double
)
suspend fun TripEntity.toDomainModel(flights: List<FlightEntity>, airports: Map<String, AirportEntity>): Trip {
    val domainFlights = flights.map { flight ->
        flight.toDomainModel(airports)
    }
    return Trip(
        tripID = tripID,
        totalDuration = totalDuration,
        price = price,
        flights = domainFlights
    )
}





