package com.example.parcial_tp3_grupo_g3.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parcial_tp3_grupo_g3.data.database.entities.AirportEntity
import com.example.parcial_tp3_grupo_g3.domain.model.Airport

@Dao
interface AirportDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAirport(airport: AirportEntity): Long

    @Query("SELECT * FROM airport")
    suspend fun getAllAirports(): List<AirportEntity>

    @Query("SELECT * FROM airport WHERE id = :airportId")
    suspend fun getAirportById(airportId: String): AirportEntity
}