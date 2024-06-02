package com.example.parcial_tp3_grupo_g3.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.parcial_tp3_grupo_g3.R


class FragTripDetails : Fragment() {
    private lateinit var btnGoBack : ImageButton
    private lateinit var view1 : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.lay_frag_trip_details, container, false)
        btnGoBack = view1.findViewById(R.id.detailsGoBackButton)
        return view1
    }

    override fun onStart() {
        super.onStart()

        btnGoBack.setOnClickListener()
        {
            findNavController().navigate(R.id.action_fragTripDetails_to_fragSearchResults)
        }
    }

}