package com.example.parcial_tp3_grupo_g3.ui.view.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.preference.PreferenceManager
import com.example.parcial_tp3_grupo_g3.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.parcial_tp3_grupo_g3.databinding.LayActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ActivityMain : AppCompatActivity() {

    lateinit var binding: LayActivityMainBinding
    private lateinit var bottomNavigation : BottomNavigationView
    private lateinit var navHostFragment : NavHostFragment
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_frag) as NavHostFragment

        navController = navHostFragment.navController

        bottomNavigation = findViewById(R.id.bottom_bar)

        NavigationUI.setupWithNavController(bottomNavigation, navHostFragment.navController)

        loadPreference()
    }

    private fun loadPreference(){
        val preference = PreferenceManager.getDefaultSharedPreferences(this)

        if (preference.getBoolean(getString(R.string.modo_oscuro), false)) {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

}