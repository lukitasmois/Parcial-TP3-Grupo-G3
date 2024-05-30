package com.example.parcial_tp3_grupo_g3.data.network

import com.example.parcial_tp3_grupo_g3.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface TripApiClient {
    @GET("search?engine=google_flights&api_key=123&departure_id=EZE&arrival_id=MIA&outbound_date=2024-05-31&return_date=2024-06-10")
    suspend fun getFlights() : Response<ApiResponse>

}