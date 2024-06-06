package com.example.parcial_tp3_grupo_g3.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.ViewModelProvider
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.databinding.LayFragTripDetailsBinding
import com.example.parcial_tp3_grupo_g3.domain.model.Trip
import com.example.parcial_tp3_grupo_g3.ui.viewmodels.TripDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragTripDetails : Fragment() {
    private var _binding: LayFragTripDetailsBinding? = null
    private val binding get() = _binding!!
    private var trip : Trip? = null

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
        val root: View = binding.root
        binding.root.setBackgroundColor(resources.getColor(R.color.background_color))

        arguments?.let {
            val tripArg = FragTripDetailsArgs.fromBundle(it).trip
            trip = tripArg
        }

        _binding!!.button.setOnClickListener {
            tripDetailsViewModel.saveTrip(trip!!)
        }

        return root
    }

    override fun onStart() {
        super.onStart()

        binding.detailsGoBackButton.setOnClickListener()
        {
            findNavController().navigate(FragTripDetailsDirections.actionFragTripDetailsToFragSearchResults())
        }
    }
}