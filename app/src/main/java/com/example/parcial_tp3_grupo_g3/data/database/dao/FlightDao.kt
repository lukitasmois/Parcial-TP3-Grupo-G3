package com.example.parcial_tp3_grupo_g3.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parcial_tp3_grupo_g3.data.database.entities.FlightEntity

@Dao
interface FlightDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlight(flight: FlightEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFlights(flights: List<FlightEntity>): List<Long> // Cambiar el tipo de retorno

    @Query("SELECT * FROM flight WHERE tripID = :tripID")
    suspend fun getFlightsByTripId(tripID: Long): List<FlightEntity>

}