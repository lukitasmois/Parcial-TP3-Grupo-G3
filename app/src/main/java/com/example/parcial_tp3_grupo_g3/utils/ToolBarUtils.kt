package com.example.parcial_tp3_grupo_g3.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.parcial_tp3_grupo_g3.R
import com.google.android.material.appbar.MaterialToolbar

object ToolBarUtils {

    fun menuToolbar(toolbar: MaterialToolbar) {
        val logoImageView = toolbar.findViewById<ImageView>(R.id.toolbar_logo) // Reemplaza R.id.logoImageView con el ID real de tu ImageView de logotipo
        val toolBarTitle = toolbar.findViewById<TextView>(R.id.toolbarTitle)

        toolbar.visibility = View.VISIBLE
        toolbar.title = ""
        toolBarTitle.visibility = View.GONE
        logoImageView.visibility = View.VISIBLE
    }

    fun pageToolbar(toolbar: MaterialToolbar, title: String) {
        val logoImageView = toolbar.findViewById<ImageView>(R.id.toolbar_logo) // Reemplaza R.id.logoImageView con el ID real de tu ImageView de logotipo
        val toolBarTitle = toolbar.findViewById<TextView>(R.id.toolbarTitle)

        toolBarTitle.text = "titled"
        toolbar.visibility = View.VISIBLE
        toolbar.title = ""
        logoImageView.visibility = View.GONE
    }
}