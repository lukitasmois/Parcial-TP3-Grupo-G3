package com.example.parcial_tp3_grupo_g3.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.parcial_tp3_grupo_g3.data.database.dao.AirportDao
import com.example.parcial_tp3_grupo_g3.data.database.dao.FlightDao
import com.example.parcial_tp3_grupo_g3.data.database.dao.TripDao
import com.example.parcial_tp3_grupo_g3.data.database.entities.AirportEntity
import com.example.parcial_tp3_grupo_g3.data.database.entities.FlightEntity
import com.example.parcial_tp3_grupo_g3.data.database.entities.TripEntity


@Database(entities = [TripEntity::class, FlightEntity::class, AirportEntity::class], version = 8)
abstract class Database : RoomDatabase() {
    abstract fun tripDao(): TripDao
    abstract fun flightDao(): FlightDao
    abstract fun airportDao(): AirportDao


}