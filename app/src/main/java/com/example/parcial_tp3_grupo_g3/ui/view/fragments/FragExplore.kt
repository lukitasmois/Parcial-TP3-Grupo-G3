package com.example.parcial_tp3_grupo_g3.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.adapters.OfferAdapterHome
import com.example.parcial_tp3_grupo_g3.adapters.TripAdapter
import com.example.parcial_tp3_grupo_g3.adapters.TripAdapterHome
import com.example.parcial_tp3_grupo_g3.databinding.LayFragExploreBinding
import com.example.parcial_tp3_grupo_g3.databinding.LayFragSearchResultsBinding
import com.example.parcial_tp3_grupo_g3.ui.viewmodels.ExploreViewModel
import com.example.parcial_tp3_grupo_g3.ui.viewmodels.SearchResultsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragExplore : Fragment() {
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
        // Inflate the layout for this fragment
        _binding = LayFragExploreBinding.inflate(inflater, container, false)
        tripAdapter = TripAdapterHome(mutableListOf())
        offerAdapter = OfferAdapterHome(mutableListOf())
        binding.root.setBackgroundColor(resources.getColor(R.color.background_color))
        viewModel.onCreate()

        binding.tripsRec.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = tripAdapter
        }

        binding.offersRec.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = offerAdapter
        }

        viewModel.tripList.observe(viewLifecycleOwner) {
            it?.let {
                tripAdapter.updateList(it)
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.loadingExplore.isVisible = it
        }

        viewModel.offerList.observe(viewLifecycleOwner) { offers ->
            offerAdapter.updateList(offers)
        }

        viewModel.item.observe(viewLifecycleOwner){ item ->
            item?.let {
                binding.layExploreInclude.homeCardOfferTripPrice.text = item.price.toString()
                Glide.with(this)
                    .load(it.image)
                    .centerCrop()
                    .into(binding.layExploreInclude.homeCardOfferTripImage)
            }
        }


        return binding.root
    }
}