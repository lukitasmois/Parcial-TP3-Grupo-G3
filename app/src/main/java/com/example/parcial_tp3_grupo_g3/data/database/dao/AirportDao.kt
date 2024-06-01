package com.example.parcial_tp3_grupo_g3.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parcial_tp3_grupo_g3.data.database.entities.AirportEntity

@Dao
interface AirportDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAirport(airport: AirportEntity): Long

    @Query("SELECT * FROM AirportEntity")
    suspend fun getAllAirports(): List<AirportEntity>

    @Query("SELECT * FROM AirportEntity WHERE id IN (:ids)")
    suspend fun getAirportsByIds(ids: List<String>): List<AirportEntity>



}