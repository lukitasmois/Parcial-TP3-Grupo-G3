package com.example.parcial_tp3_grupo_g3.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
   @SerializedName("best_flights") val trips: List<TripModel>
)
