package com.example.parcial_tp3_grupo_g3.domain.model

import com.example.parcial_tp3_grupo_g3.data.database.entities.AirportEntity

data class Airport(
    val name : String,
    val id : String,
    val time : String
)

fun Airport.toAirportEntity(): AirportEntity {
    return AirportEntity(
        id = this.id,
        name = this.name,
        time = this.time
    )
}