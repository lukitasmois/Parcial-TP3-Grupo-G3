package com.example.parcial_tp3_grupo_g3.ui.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial_tp3_grupo_g3.domain.GetTripsUseCase
import com.example.parcial_tp3_grupo_g3.domain.model.Trip
import com.example.parcial_tp3_grupo_g3.ui.view.entities.Offer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val getTripsUseCase: GetTripsUseCase,
    private val context: Context
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val tripList = MutableLiveData<MutableList<Trip>>()
    val offerList = MutableLiveData<MutableList<Offer>>()
    private val _item = MutableLiveData<Trip>()
    val item: LiveData<Trip> get() = _item

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getTripsUseCase.invoke()
            val offers = getOffers()


            if(!result.isNullOrEmpty()){
                tripList.postValue(result.toMutableList())
                _item.postValue(result[Random.nextInt(0, result.size)])
            }
            if (!offers.isNullOrEmpty()) {
                offerList.postValue(offers)
            }
            isLoading.postValue(false)
        }
    }





    private fun getOffers(): MutableList<Offer> {
        val data: MutableList<Offer>
        val json = context.assets?.open("offers.json")?.bufferedReader().use { it?.readText() }
        data = json?.let { Json.decodeFromString<MutableList<Offer>>(it) } ?: mutableListOf()
        return data
    }

}