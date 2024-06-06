package com.example.parcial_tp3_grupo_g3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcial_tp3_grupo_g3.R

class TripDetailsImageAdapter(private val imageUrls: List<String>) : RecyclerView.Adapter<TripDetailsImageAdapter.TripDetailsImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripDetailsImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lay_item_details_image, parent, false)
        return TripDetailsImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: TripDetailsImageViewHolder, position: Int) {
        holder.bind(imageUrls[position])
    }

    override fun getItemCount(): Int = imageUrls.size

    class TripDetailsImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.itemDetailsImage)

        fun bind(imageUrl: String) {
            Glide.with(itemView.context)
                .load(imageUrl)
                .centerCrop()
                .into(imageView)
        }
    }
}