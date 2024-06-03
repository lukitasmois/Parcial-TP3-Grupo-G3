package com.example.parcial_tp3_grupo_g3.di

import android.content.Context
import androidx.room.Room
import com.example.parcial_tp3_grupo_g3.data.database.Database
import com.example.parcial_tp3_grupo_g3.data.database.dao.AirportDao
import com.example.parcial_tp3_grupo_g3.data.database.dao.FlightDao
import com.example.parcial_tp3_grupo_g3.data.database.dao.TripDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val  TRIP_DATABASE_NAME = "trip_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, Database::class.java, TRIP_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideTripDao(db: Database): TripDao = db.tripDao()

    @Singleton
    @Provides
    fun provideFlightDao(db: Database): FlightDao = db.flightDao()

    @Singleton
    @Provides
    fun provideAirportDao(db: Database): AirportDao = db.airportDao()

}