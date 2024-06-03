package com.example.parcial_tp3_grupo_g3.data.network

import android.util.Log
import com.example.parcial_tp3_grupo_g3.data.model.TripModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TripService @Inject constructor(
    private val service: TripApiClient) {

    suspend fun getTrips(): List<TripModel> {
        return withContext(Dispatchers.IO) {
            val response = try {
                service.getTrips()
            } catch (e: Exception) {
                Log.e("Service", "no hay conexion")
                null
            }

            if (response != null && response.isSuccessful) {
                val apiResponse = response.body()
                //apiResponse?.images?.map { DogModel(it) } ?: emptyList()
                apiResponse?.trips?.map { trip ->
                    TripModel(
                    flights = trip.flights,
                        totalDuration = trip.totalDuration,
                        price = trip.price,
                        departureToken = trip.departureToken,
                        type = trip.type
                ) } ?: emptyList()
            } else {
                emptyList()
            }
        }
    }
}