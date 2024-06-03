package com.example.parcial_tp3_grupo_g3.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.parcial_tp3_grupo_g3.data.database.entities.TripEntity


@Dao
interface TripDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTrip(trip: TripEntity): Long

    @Query("SELECT * FROM trips_table WHERE tripID = :tripID")
    suspend fun getTripById(tripID: String): TripEntity

    @Transaction
    @Query("SELECT * FROM trips_table")
    suspend fun getAllTrips(): List<TripEntity>

    @Query("DELETE FROM trips_table WHERE tripID = :tripID")
    suspend fun deleteTrip(tripID: String)

    @Query("DELETE FROM trips_table")
    suspend fun deleteAllTrips()

    @Query("UPDATE trips_table SET isSaved = :isSaved WHERE tripID = :tripID")
    suspend fun saveTripOnDB(tripID: String, isSaved: Boolean)
}