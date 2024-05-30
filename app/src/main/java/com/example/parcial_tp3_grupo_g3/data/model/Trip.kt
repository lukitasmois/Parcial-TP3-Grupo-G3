package com.example.parcial_tp3_grupo_g3.data.model

import com.google.gson.annotations.SerializedName

data class Trip(
    val Flights: List<Flight>,
    @SerializedName("total_duration") val totalDuration: Int,
    @SerializedName("price") val price: Int
)
