package com.example.parcial_tp3_grupo_g3.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.databinding.LayFragSearchBinding
import com.example.parcial_tp3_grupo_g3.ui.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragSearch : Fragment() {
    private var _binding: LayFragSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayFragSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val searchButton: Button = binding.layFragBttonSearch



        searchButton.setOnClickListener() {
            view?.findNavController()?.navigate(FragSearchDirections.actionFragSearchToFragSearchResults())
        }

        root.setBackgroundColor(resources.getColor(R.color.background_color))

        return root
    }
}