package com.example.parcial_tp3_grupo_g3.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.adapters.TripAdapter
import com.example.parcial_tp3_grupo_g3.databinding.LayFragSearchResultsBinding
import com.example.parcial_tp3_grupo_g3.domain.model.Trip
import com.example.parcial_tp3_grupo_g3.listeners.ItemClickListener
import com.example.parcial_tp3_grupo_g3.listeners.SaveClickListener
import com.example.parcial_tp3_grupo_g3.ui.viewmodels.SearchResultsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragSearchResults : Fragment(), SaveClickListener {
    private var _binding:LayFragSearchResultsBinding? = null
    private val binding get() = _binding!!
    private val searchResultsViewModel : SearchResultsViewModel by viewModels()
    private lateinit var tripAdapter: TripAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayFragSearchResultsBinding.inflate(inflater, container, false)
        tripAdapter = TripAdapter(mutableListOf(), searchResultsViewModel)
        searchResultsViewModel.onCreate()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = tripAdapter
        }

        //Actualiza la RecyclerView con los datos de la búsqueda
        searchResultsViewModel.tripList.observe(viewLifecycleOwner) {
            it?.let {
                tripAdapter.updateList(it)
            }
        }

        searchResultsViewModel.isLoading.observe(viewLifecycleOwner) {
            binding.loading.isVisible = it
        }

        searchResultsViewModel.navigateToTripDetails.observe(viewLifecycleOwner) { trip ->
            trip?.let {
                findNavController().navigate(FragSearchResultsDirections.actionFragSearchResultsToFragTripDetails(trip))
                searchResultsViewModel.navigateToTripDetails.value = null
            }
        }

        return binding.root
    }

    override fun saveTrip(trip: Trip) {
        view?.findNavController()?.navigate(FragSearchResultsDirections.actionFragSearchResultsToFragSearch())
    }

}
