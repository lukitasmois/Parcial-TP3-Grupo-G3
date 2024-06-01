package com.example.parcial_tp3_grupo_g3.domain

import com.example.parcial_tp3_grupo_g3.data.TripRepository
import com.example.parcial_tp3_grupo_g3.data.database.dao.AirportDao
import com.example.parcial_tp3_grupo_g3.data.database.dao.FlightDao
import com.example.parcial_tp3_grupo_g3.data.database.dao.TripDao
import com.example.parcial_tp3_grupo_g3.data.database.entities.AirportEntity
import com.example.parcial_tp3_grupo_g3.data.database.entities.FlightEntity
import com.example.parcial_tp3_grupo_g3.data.database.entities.TripEntity
import com.example.parcial_tp3_grupo_g3.data.database.entities.toDomainModel
import com.example.parcial_tp3_grupo_g3.data.model.AirportModel
import com.example.parcial_tp3_grupo_g3.data.model.TripModel
import com.example.parcial_tp3_grupo_g3.domain.model.Airport
import com.example.parcial_tp3_grupo_g3.domain.model.Trip


import javax.inject.Inject

class GetTripsUseCase @Inject constructor(
    private val repository: TripRepository,
    private val tripDao: TripDao,
    private val flightDao: FlightDao,
    private val airportDao: AirportDao,
){
    suspend operator fun invoke(): List<Trip> {
        val trips = repository.getAllTripsFromApi()
        return if (trips.isNotEmpty()) {
            tripDao.deleteAllTrips()
            val insertedTrips = insertTrips(trips)
            insertedTrips.map { it.toDomainModel(getFlightsForTrip(it.tripID), getAllAirports()) } // Convertir a modelos de dominio
        } else {
            val tripsFromDb = repository.getAllTripsFromDatabase()
            tripsFromDb.map { it.toDomainModel(getFlightsForTrip(it.tripID), getAllAirports()) } // Convertir a modelos de dominio
        }
    }

    private suspend fun insertTrips(trips: List<TripModel>): List<TripEntity> {
        val insertedTripEntities = mutableListOf<TripEntity>()
        trips.forEach { trip ->
            val tripEntity = TripEntity(
                totalDuration = trip.totalDuration,
                price = trip.price
            )
            val tripId = tripDao.insertTrip(tripEntity)
            val flightEntities = trip.flights.map { flight ->
                val departureAirportId = insertAirport(flight.departure_airport)
                val arrivalAirportId = insertAirport(flight.arrival_airport)
                FlightEntity(
                    airlineName = flight.airlineName,
                    airlineLogo = flight.airlineLogo,
                    travelClass = flight.travelClass,
                    tripID = tripId,
                    departure_airport_id = departureAirportId,
                    arrival_airport_id = arrivalAirportId
                )
            }
            flightDao.insertAllFlights(flightEntities)
            insertedTripEntities.add(tripEntity)
        }
        return insertedTripEntities
    }

    private suspend fun insertAirport(airport: Airport): String {
        val airportEntity = AirportEntity(
            id = airport.id,
            name = airport.name,
            time = airport.time
        )
        airportDao.insertAirport(airportEntity)
        return airport.id
    }


    //moverl al repository
    private suspend fun getFlightsForTrip(tripId: Long): List<FlightEntity> {
        return flightDao.getFlightsByTripId(tripId)
    }

    private suspend fun getAllAirports(): Map<String, AirportEntity> {
        return airportDao.getAllAirports().associateBy { it.id }
    }
}
