package com.example.parcial_tp3_grupo_g3.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.parcial_tp3_grupo_g3.R


class FragProfile : Fragment() {
    lateinit var view1: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view1= inflater.inflate(R.layout.lay_frag_explore, container, false)
        view1.setBackgroundColor(resources.getColor(R.color.background_color))
        return view1
    }

}