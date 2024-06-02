package com.example.parcial_tp3_grupo_g3.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.parcial_tp3_grupo_g3.domain.model.Trip
import com.example.parcial_tp3_grupo_g3.domain.GetTripsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultsViewModel@Inject constructor(
    private val getTripsUseCase : GetTripsUseCase,

    ) : ViewModel(){

        val isLoading = MutableLiveData<Boolean>()
        val tripList = MutableLiveData<MutableList<Trip>>()

        fun onCreate(){
            viewModelScope.launch {
                isLoading.postValue(true)
                val result = getTripsUseCase.invoke()

                for (trip in result){
                    Log.d("vuelos de trip $trip", trip.flights.size.toString())
                }

                if(!result.isNullOrEmpty()){
                    tripList.postValue(result.toMutableList())

                }
                isLoading.postValue(false)

            }
        }

}