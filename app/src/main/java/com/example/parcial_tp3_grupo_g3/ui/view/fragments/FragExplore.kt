package com.example.parcial_tp3_grupo_g3.ui.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.adapters.OfferAdapterHome
import com.example.parcial_tp3_grupo_g3.adapters.TripAdapterHome
import com.example.parcial_tp3_grupo_g3.databinding.LayFragExploreBinding
import com.example.parcial_tp3_grupo_g3.domain.model.Trip
import com.example.parcial_tp3_grupo_g3.listeners.ItemClickListener
import com.example.parcial_tp3_grupo_g3.ui.viewmodels.ExploreViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class FragExplore : Fragment(), ItemClickListener {
    private var _binding: LayFragExploreBinding? = null
    private val binding get() = _binding!!
    private val viewModel : ExploreViewModel by viewModels()
    private lateinit var tripAdapter: TripAdapterHome
    private lateinit var offerAdapter: OfferAdapterHome
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayFragExploreBinding.inflate(inflater, container, false)
        tripAdapter = TripAdapterHome(mutableListOf(), this)
        offerAdapter = OfferAdapterHome(mutableListOf())
        viewModel.onCreate()

        binding.tripsRec.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = tripAdapter
        }

        binding.offersRec.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = offerAdapter
        }

        //Guardar o no el Trip de "destacado"
        binding.layExploreInclude.homeCardOfferTripButtonSave.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                val trip = viewModel.item.value
                if (trip != null) {
                    viewModel.saveTrip(trip)
                }
            }
        }

        //Navegacion del boton "Flights"
        binding.layExploreButtonTrips.setOnClickListener {
            findNavController().navigate(FragExploreDirections.actionFragExploreToFragSearchResults())
        }

        //Actualizar el RecyclerView de Trips y Offers
        viewModel.tripList.observe(viewLifecycleOwner) {
            it?.let {
                tripAdapter.updateList(it)
            }
        }

        viewModel.offerList.observe(viewLifecycleOwner) { offers ->
            offerAdapter.updateList(offers)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.loadingExplore.isVisible = it
        }


        //Carga la imagen del Trip "destacado"
        viewModel.item.observe(viewLifecycleOwner){ item ->
            item?.let {
                binding.layExploreInclude.homeCardOfferTripPrice.text = item.price.toString()
                Glide.with(this)
                    .load(it.image)
                    .centerCrop()
                    .into(binding.layExploreInclude.homeCardOfferTripImage)
            }
        }

        //Actualiza el boton de "guardar" el Trip "destacado"
        viewModel.item.observe(viewLifecycleOwner) { trip ->
            trip?.let {
                updateSaveButtonIcon(it)
            }
        }

        return binding.root
    }

    private fun updateSaveButtonIcon(trip: Trip) {
        binding.layExploreInclude.homeCardOfferTripButtonSave.setImageResource(
            if (trip.isSaved) R.drawable.ic_heart_true else R.drawable.ic_heart_false
        )
    }

    override fun navigateToTripDetails(trip: Trip) {
        findNavController().navigate(FragExploreDirections.actionFragExploreToFragTripDetails(trip))
    }

}