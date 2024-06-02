package com.example.parcial_tp3_grupo_g3.ui.view.holders

import android.view.TextureView
import android.view.View
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

}