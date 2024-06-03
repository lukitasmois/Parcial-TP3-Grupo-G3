package com.example.parcial_tp3_grupo_g3.ui.view.holders

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3_grupo_g3.R

class OfferHolder (v: View): RecyclerView.ViewHolder(v) {

    private var view:View
    init{
        this.view = v
    }

    fun setTitle(titletext:String){
        val title: TextView = view.findViewById(R.id.lay_offer_text_title)
        title.text = titletext
    }

    fun setBody(bodytext:String){
        val body: TextView = view.findViewById(R.id.lay_offer_body)
        body.text = bodytext
    }

    fun setImage(drawable: Drawable){
        val image : ImageView = view.findViewById((R.id.lay_card_Image))
        image.setImageDrawable(drawable)
    }

}