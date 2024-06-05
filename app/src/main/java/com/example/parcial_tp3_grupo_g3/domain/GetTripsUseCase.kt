package com.example.parcial_tp3_grupo_g3.domain

import android.util.Log
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
import kotlin.random.Random

class GetTripsUseCase @Inject constructor(
    private val repository: TripRepository,
    private val tripDao: TripDao,
    private val flightDao: FlightDao,
    private val airportDao: AirportDao,
) {
    suspend operator fun invoke(): List<Trip> {
        val trips = repository.getAllTripsFromApi()
        return if (trips.isNotEmpty()) {
            //tripDao.deleteAllTrips()

            val insertedTrips = insertTrips(trips)
            // Obtener los vuelos y aeropuertos después de la inserción
            val allAirports = repository.getAllAirports()

            insertedTrips.map { tripEntity ->
                val flights = repository.getFlightsForTrip(tripEntity.tripID)
                tripEntity.toDomainModel(flights, allAirports)
            }
        } else {
            repository.getAllTripsFromDatabase()
        }
    }


    private suspend fun insertTrips(trips: List<TripModel>): List<TripEntity> {
        val insertedTripEntities = mutableListOf<TripEntity>()
        trips.forEach { trip ->
            val tripID = generateTripID(trip.departureToken, trip.type)
            // Crear la entidad TripEntity
            val tripEntity = TripEntity(
                tripID = tripID,
                totalDuration = trip.totalDuration,
                price = trip.price,
                departureToken = trip.departureToken,
                type = trip.type,
                image = setImage(Random.nextInt(0,4)),
                isSaved = false
            )
            // Insertar el viaje y obtener su ID generado
            tripDao.insertTrip(tripEntity)


            // Mapeo de los vuelos
            val flightEntities = trip.flights.map { flight ->
                val departureAirportId = insertAirport(flight.departure_airport)
                val arrivalAirportId = insertAirport(flight.arrival_airport)

                val flightEntity = FlightEntity(
                    airlineName = flight.airlineName,
                    airlineLogo = flight.airlineLogo,
                    travelClass = flight.travelClass,
                    tripID = tripID.toString(), // Usar el ID del viaje generado
                    departure_airport_id = departureAirportId,
                    arrival_airport_id = arrivalAirportId,
                )
                flightEntity
            }

            // Insertar los vuelos
            flightDao.insertAllFlights(flightEntities)

            // Agregar el viaje insertado a la lista de entidades de viaje insertadas
            insertedTripEntities.add(tripEntity)
        }
        return insertedTripEntities
    }

    private fun setImage(randomNumber: Int): String {
        return when(randomNumber){
            0 -> "https://i.imgur.com/xxVatVq.jpeg"
            1 -> "https://i.imgur.com/XmmidzY.jpeg"
            2 -> "https://i.imgur.com/fZIT91e.jpeg"
            3 -> "https://i.imgur.com/aVc64h0.jpeg"
            4 -> "https://i.imgur.com/NI9D9rX.jpeg"
            else -> "https://i.imgur.com/hSr2Cdq.jpeg"
        }
    }

    private fun generateTripID(departureToken: String, type: String): String {
        val id = departureToken.hashCode().toString() + "_" + type.hashCode().toString()
        Log.e("GetTripsUseCase", "generando id de viaje: $id")
        return id

    }

    private suspend fun insertAirport(airport: AirportModel): String {
        val airportEntity = AirportEntity(
            id = airport.id,
            name = airport.name,
            time = airport.time
        )
        airportDao.insertAirport(airportEntity)
        return airport.id
    }

    suspend fun saveTrip(trip: Trip) {
        val tripDB = tripDao.getTripById(trip.tripID)
        if (tripDB.isSaved) {
            tripDao.saveTripOnDB(trip.tripID, false)
        }else{
            tripDao.saveTripOnDB(trip.tripID, true)
        }

    }

    suspend fun getItemRandom(): Trip {
        val tripWeekID = "-1374620035_1789351831"
        val trip = tripDao.getTripById(tripWeekID)
        val flights = repository.getFlightsForTrip(tripWeekID)
        val allAirports = repository.getAllAirports()


        return trip.toDomainModel(flights, allAirports)
    }
}

