package com.example.parcial_tp3_grupo_g3.ui.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.ui.view.adapters.OfferAdapter
import com.example.parcial_tp3_grupo_g3.ui.view.entities.Offer
import kotlinx.serialization.*
import kotlinx.serialization.json.*


class FragOffers : Fragment() {

    lateinit var offerRecycler:RecyclerView
    lateinit var manager: RecyclerView.LayoutManager
    lateinit var viewOffer:View
    lateinit var offerAdapter: OfferAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewOffer = inflater.inflate(R.layout.lay_frag_offers, container, false)
        viewOffer.setBackgroundColor(resources.getColor(R.color.background_color))
        offerRecycler = viewOffer.findViewById(R.id.offerRecyclerView)
        return viewOffer
    }

    override fun onStart() {
        super.onStart()
        offerRecycler.setHasFixedSize(true)
        val offers = getOffers()
        manager = LinearLayoutManager(context)
        offerAdapter = OfferAdapter(offers)

        offerRecycler.layoutManager = manager
        offerRecycler.adapter = offerAdapter



    }

    fun getOffers(): MutableList<Offer>? {
        val data:MutableList<Offer>

        val json = context?.assets?.open("offers.json")?.bufferedReader().use { it?.readText()}
        data = json?.let { Json.decodeFromString<MutableList<Offer>>(it) }!!
        Log.d("json",data.toString())
        return data
    }

}