package com.example.parcial_tp3_grupo_g3.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.adapters.TripDetailsImageAdapter
import com.example.parcial_tp3_grupo_g3.databinding.LayFragTripDetailsBinding
import com.example.parcial_tp3_grupo_g3.domain.model.Trip
import com.example.parcial_tp3_grupo_g3.ui.viewmodels.TripDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragTripDetails : Fragment() {
    private var _binding: LayFragTripDetailsBinding? = null
    private val binding get() = _binding!!
    private var trip : Trip? = null
    private lateinit var root : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val tripDetailsViewModel = ViewModelProvider(this).get(TripDetailsViewModel::class.java)
        _binding = LayFragTripDetailsBinding.inflate(inflater, container, false)
        root = binding.root
        binding.root.setBackgroundColor(resources.getColor(R.color.background_color))

        arguments?.let {
            val tripArg = FragTripDetailsArgs.fromBundle(it).trip
            trip = tripArg
            tripDetailsViewModel.setTripDetails(tripArg)
        }

        _binding!!.button.setOnClickListener {
            tripDetailsViewModel.saveTrip(trip!!)
        }

        tripDetailsViewModel.tripDetails.observe(viewLifecycleOwner, Observer { trip ->
            this.trip = trip
            bindTripDetails(trip)
        })

        return root
    }

    private fun bindTripDetails(trip: Trip?)
    {
        trip?.let {
            val arrivalAirport = it.flights.firstOrNull()?.arrival_airport?.id ?: "Unknown Location"
            binding.location.text = arrivalAirport
            binding.country.text = it.flights.firstOrNull()?.arrival_airport?.name
            binding.locationAmount.text = "$${it.price}"

            setupRecyclerView()
        } ?: run {
            binding.location.text = "Trip details not available"
            binding.locationAmount.text = "N/A"
            binding.country.text = "N/A"
        }
    }

    private fun setupRecyclerView() {
        val imageUrls = List(5) { index -> setImage(index) }
        val adapter = TripDetailsImageAdapter(imageUrls)
        binding.detailsPhotoRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.detailsPhotoRecyclerView.adapter = adapter
    }

    private fun setImage(randomNumber: Int): String {
        return when (randomNumber) {
            0 -> "https://i.imgur.com/xxVatVq.jpeg"
            1 -> "https://i.imgur.com/XmmidzY.jpeg"
            2 -> "https://i.imgur.com/fZIT91e.jpeg"
            3 -> "https://i.imgur.com/aVc64h0.jpeg"
            4 -> "https://i.imgur.com/NI9D9rX.jpeg"
            else -> "https://i.imgur.com/hSr2Cdq.jpeg"
        }
    }

    override fun onStart() {
        super.onStart()

        binding.detailsGoBackButton.setOnClickListener()
        {
            findNavController().navigate(R.id.action_fragTripDetails_to_fragSearchResults)
        }
    }
}