package com.example.parcial_tp3_grupo_g3.data

import android.util.Log
import com.example.parcial_tp3_grupo_g3.data.database.dao.AirportDao
import com.example.parcial_tp3_grupo_g3.data.database.dao.FlightDao
import com.example.parcial_tp3_grupo_g3.data.database.dao.TripDao
import com.example.parcial_tp3_grupo_g3.data.database.entities.AirportEntity
import com.example.parcial_tp3_grupo_g3.data.database.entities.FlightEntity
import com.example.parcial_tp3_grupo_g3.data.database.entities.TripEntity
import com.example.parcial_tp3_grupo_g3.data.database.entities.TripWithFlights
import com.example.parcial_tp3_grupo_g3.data.database.entities.toDomainModel
import com.example.parcial_tp3_grupo_g3.data.model.toDomain
import com.example.parcial_tp3_grupo_g3.data.model.TripModel
import com.example.parcial_tp3_grupo_g3.data.network.TripService
import com.example.parcial_tp3_grupo_g3.domain.model.Trip
import javax.inject.Inject

class TripRepository @Inject constructor(
    private val remote: TripService,
    private val tripDao : TripDao,
    private val flightDao: FlightDao,
    private val airportDao: AirportDao
){
    suspend fun getAllTripsFromApi(): List<TripModel> {
        val response: List<TripModel> = remote.getTrips()
        return response.map { it.toDomain() }
    }

    suspend fun getAllTripsFromDatabase(): List<Trip> {
        val trips = tripDao.getAllTrips()
        val allAirports = getAllAirports()
        return trips.map { trip ->
            val flights = getFlightsForTrip(trip.tripID)
            trip.toDomainModel(flights, allAirports)
        }
    }

    suspend fun getFlightsForTrip(tripId: Long): List<FlightEntity> {
        val flightEntities = flightDao.getFlightsByTripId(tripId)
        return flightEntities
    }

    suspend fun getAllAirports(): Map<String, AirportEntity> {
        return airportDao.getAllAirports().associateBy { it.id }
    }
}