package com.example.parcial_tp3_grupo_g3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.domain.model.Offer
import com.example.parcial_tp3_grupo_g3.holders.OfferHolder

class OfferAdapter(val offers: MutableList<Offer>?) : RecyclerView.Adapter<OfferHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lay_offer,parent,false)
        return(OfferHolder(view))
    }

    override fun getItemCount(): Int {
        return offers?.size!!
    }

    override fun onBindViewHolder(holder: OfferHolder, position: Int) {

        val offer = offers?.get(position)
        if (offer != null) {
            holder.setTitle(offer.titletext)
            holder.setBody(offer.bodytext)
            holder.setImage(offer.cardImg)
        }
    }
}