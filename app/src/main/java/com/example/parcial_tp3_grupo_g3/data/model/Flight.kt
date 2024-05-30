package com.example.parcial_tp3_grupo_g3.data.model

import com.google.gson.annotations.SerializedName

data class Flight(
    val departure_airport : Airport,
    val arrival_airport : Airport,
    @SerializedName("airline") val airlineName: String,
    @SerializedName("airline_logo") val airlineLogo: String,
    @SerializedName("travel_class") val travelClass: String,


)
