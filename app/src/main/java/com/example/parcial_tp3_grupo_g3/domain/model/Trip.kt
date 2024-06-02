package com.example.parcial_tp3_grupo_g3.domain.model


data class Trip(
    val flights: List<Flight>,
    val totalDuration: Int,
    val price: Double,
    val tripID: Long,
)




