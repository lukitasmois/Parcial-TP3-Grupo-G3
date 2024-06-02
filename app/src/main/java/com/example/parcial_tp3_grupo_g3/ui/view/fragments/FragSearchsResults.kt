package com.example.parcial_tp3_grupo_g3.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.ImageButton
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.adapters.TripAdapter
import com.example.parcial_tp3_grupo_g3.databinding.LayFragSearchResultsBinding
import com.example.parcial_tp3_grupo_g3.ui.viewmodels.SearchResultsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragSearchsResults : Fragment() {
    private var _binding:LayFragSearchResultsBinding? = null
    private val binding get() = _binding!!
    private val searchsResultsViewModel : SearchResultsViewModel by viewModels()
    private lateinit var tripAdapter: TripAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayFragSearchResultsBinding.inflate(inflater, container, false)
        tripAdapter = TripAdapter(mutableListOf())
        binding.root.setBackgroundColor(resources.getColor(R.color.background_color))
        searchsResultsViewModel.onCreate()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = tripAdapter
        }

        searchsResultsViewModel.tripList.observe(viewLifecycleOwner) {
            it?.let {
                tripAdapter.updateList(it)
            }
        }

        searchsResultsViewModel.isLoading.observe(viewLifecycleOwner) {
            binding.loading.isVisible = it
        }




        return binding.root
    }

    override fun onStart() {
        super.onStart()

        _binding?.imageButton?.setOnClickListener()
        {
            findNavController().navigate(FragSearchsResultsDirections.actionFragSearchsResultsToFragSearch())
        }
    }


    }