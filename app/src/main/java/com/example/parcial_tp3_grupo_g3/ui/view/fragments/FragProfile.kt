package com.example.parcial_tp3_grupo_g3.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import com.example.parcial_tp3_grupo_g3.R


class FragProfile : Fragment() {
    lateinit var view1: View
    lateinit var cardSettings: CardView
    lateinit var buttonBack : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view1= inflater.inflate(R.layout.lay_frag_profile, container, false)
        view1.setBackgroundColor(resources.getColor(R.color.background_color))
        cardSettings = view1.findViewById(R.id.lay_profile_settingbutton)
        buttonBack = view1.findViewById(R.id.frag_profile_backButton)

        cardSettings.setOnClickListener {
            findNavController().navigate(FragProfileDirections.actionFragProfileToFragSettings3())
        }

        buttonBack.setOnClickListener {
            findNavController().navigate(FragProfileDirections.actionFragProfileToFragExplore())
        }

        return view1
    }

}