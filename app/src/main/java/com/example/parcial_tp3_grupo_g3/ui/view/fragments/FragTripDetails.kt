package com.example.parcial_tp3_grupo_g3.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.databinding.LayFragSearchResultsBinding
import com.example.parcial_tp3_grupo_g3.databinding.LayFragTripDetailsBinding
import com.example.parcial_tp3_grupo_g3.ui.viewmodels.SearchResultsViewModel
import com.example.parcial_tp3_grupo_g3.ui.viewmodels.TripDetailsViewModel


class FragTripDetails : Fragment() {
    private var _binding: LayFragTripDetailsBinding? = null
    private val binding get() = _binding!!
    private val tripDetailsViewModel : TripDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayFragTripDetailsBinding.inflate(inflater, container, false)
        binding.root.setBackgroundColor(resources.getColor(R.color.background_color))



        return binding.root
    }

}