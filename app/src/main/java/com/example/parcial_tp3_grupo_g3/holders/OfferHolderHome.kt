package com.example.parcial_tp3_grupo_g3.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcial_tp3_grupo_g3.R

class OfferHolderHome (v: View): RecyclerView.ViewHolder(v) {

    private var view: View

    init {
        this.view = v
    }

    fun setOffer(offer: String) {
        val itemOffer = view.findViewById<TextView>(R.id.item_offer_home_offer)
        itemOffer.text = offer
    }

    fun setImage(image: String){
        val Itemimage : ImageView = view.findViewById((R.id.item_offer_cardImage))
        Glide.with(view.context).load(image).centerCrop().into(Itemimage)
    }
}