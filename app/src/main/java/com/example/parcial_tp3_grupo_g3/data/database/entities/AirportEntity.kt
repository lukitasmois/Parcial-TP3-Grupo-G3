package com.example.parcial_tp3_grupo_g3.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.parcial_tp3_grupo_g3.domain.model.Airport

@Entity
data class AirportEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val time: String
)

fun AirportEntity.toDomainModel(): Airport {
    return Airport(
        name = this.name,
        id = this.id,
        time = this.time
    )
}