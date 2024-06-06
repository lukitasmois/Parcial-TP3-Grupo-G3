package com.example.parcial_tp3_grupo_g3.ui.viewmodels


import android.util.Log
import android.widget.ImageButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _tripDetails = MutableLiveData<Trip?>()
    val tripDetails: LiveData<Trip?> get() = _tripDetails


    fun setTripDetails(trip: Trip) {
        _tripDetails.value = trip
    }

    override fun saveTrip(trip: Trip) {
        viewModelScope.launch {
            getTripsUseCase.saveTrip(trip)
            trip.isSaved = !trip.isSaved
            _tripDetails.postValue(trip)
        }
    }

    override fun navigateToTripDetails(trip: Trip) {
        TODO("Not yet implemented")
    }}