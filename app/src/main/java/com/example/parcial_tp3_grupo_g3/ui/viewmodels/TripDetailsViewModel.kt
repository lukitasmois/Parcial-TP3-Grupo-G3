package com.example.parcial_tp3_grupo_g3.ui.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial_tp3_grupo_g3.data.TripRepository
import com.example.parcial_tp3_grupo_g3.data.database.dao.TripDao
import com.example.parcial_tp3_grupo_g3.domain.GetTripsUseCase
import com.example.parcial_tp3_grupo_g3.domain.model.Trip
import com.example.parcial_tp3_grupo_g3.listeners.ItemClickListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TripDetailsViewModel @Inject constructor(
    private val getTripsUseCase : GetTripsUseCase,

    ) : ViewModel(), ItemClickListener {

    override  fun saveTrip(trip: Trip) {
        viewModelScope.launch {
            getTripsUseCase.saveTrip(trip)
        }
    }

    override fun navigateToTripDetails(trip: Trip) {
        TODO("Not yet implemented")
    }}