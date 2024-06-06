package com.example.parcial_tp3_grupo_g3.utils

import android.view.View
import com.example.parcial_tp3_grupo_g3.databinding.LayActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar

object ToolBarUtils {

     fun showLogo(toolbar: MaterialToolbar, binding: LayActivityMainBinding) {
        toolbar.title = ""
        binding.toolbarTitle.text = ""
        val logoImageView = binding.toolbarLogo
        logoImageView.visibility = View.VISIBLE
    }

    fun hideLogo(toolbar: MaterialToolbar, title: String, binding: LayActivityMainBinding){
        toolbar.title = ""
        binding.toolbarTitle.text = title
        val logoImageView = binding.toolbarLogo
        logoImageView.visibility = View.GONE

    }

     fun hideToolbar(toolbar: MaterialToolbar, binding: LayActivityMainBinding){
        toolbar.visibility = View.GONE
        binding.myAppBarLayout.visibility = View.GONE
    }
}