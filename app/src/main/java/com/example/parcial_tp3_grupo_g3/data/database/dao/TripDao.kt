package com.example.parcial_tp3_grupo_g3.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.parcial_tp3_grupo_g3.data.database.entities.TripEntity
import com.example.parcial_tp3_grupo_g3.data.database.entities.TripWithFlights


@Dao
interface TripDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrip(trip: TripEntity): Long

    @Query("SELECT * FROM trips_table WHERE tripID = :tripID")
    suspend fun getTripById(tripID: Long): TripEntity

    @Transaction
    @Query("SELECT * FROM trips_table")
    suspend fun getAllTrips(): List<TripEntity>

    @Query("DELETE FROM trips_table WHERE tripId = :tripId")
    suspend fun deleteTrip(tripId: Long)

    @Query("DELETE FROM trips_table")
    suspend fun deleteAllTrips()
}