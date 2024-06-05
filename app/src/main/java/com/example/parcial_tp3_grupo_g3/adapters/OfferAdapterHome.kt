package com.example.parcial_tp3_grupo_g3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3_grupo_g3.R
import com.example.parcial_tp3_grupo_g3.domain.model.Trip
import com.example.parcial_tp3_grupo_g3.holders.OfferHolderHome
import com.example.parcial_tp3_grupo_g3.ui.view.entities.Offer
import com.example.parcial_tp3_grupo_g3.ui.view.holders.OfferHolder

class OfferAdapterHome(
    var offerList: MutableList<Offer>

) : RecyclerView.Adapter<OfferHolderHome>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferHolderHome {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lay_item_offers_home,parent,false)
        return(OfferHolderHome(view))
    }


    override fun onBindViewHolder(holder: OfferHolderHome, position: Int) {
        val offer = offerList[position]
        holder.setOffer(offer.titletext)
        holder.setImage(offer.cardImg)
    }

    override fun getItemCount() = offerList.size


    fun updateList(newList: MutableList<Offer>) {
        offerList = newList.toMutableList()
        notifyDataSetChanged()
    }

}