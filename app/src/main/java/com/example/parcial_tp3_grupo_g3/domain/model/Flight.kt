package com.example.parcial_tp3_grupo_g3.domain.model

import com.example.parcial_tp3_grupo_g3.data.database.entities.AirportEntity


data class Flight(
    val departure_airport : Airport,
    val arrival_airport : Airport,
    val airlineName: String,
    val airlineLogo: String,
    val travelClass: String,
)



