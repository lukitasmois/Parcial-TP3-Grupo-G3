package com.example.parcial_tp3_grupo_g3.listeners

import com.example.parcial_tp3_grupo_g3.domain.model.Trip

interface ItemClickListener {
       fun saveTrip(trip: Trip)
      fun navigateToTripDetails(trip: Trip)
}