package com.example.parcial_tp3_grupo_g3.data.database.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.parcial_tp3_grupo_g3.data.model.Flight
import com.example.parcial_tp3_grupo_g3.domain.model.Trip

data class TripWithFlights(
    @Embedded val trip: TripEntity,
    @Relation(
        parentColumn = "tripID",
        entityColumn = "tripID"
    )
    val flights: List<FlightEntity>
)


