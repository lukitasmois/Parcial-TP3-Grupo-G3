package com.example.parcial_tp3_grupo_g3.ui.view.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.example.parcial_tp3_grupo_g3.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.parcial_tp3_grupo_g3.databinding.LayActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ActivityMain : AppCompatActivity() {

    lateinit var binding: LayActivityMainBinding
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var drawer: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: MaterialToolbar


    private val fragmentsNavigation = setOf(
        R.id.fragExplore
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_frag) as NavHostFragment

        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = fragmentsNavigation,
            drawerLayout = binding.activityMainDrawerLayout
        )

        setSupportActionBar(binding.customToolbar)

        bottomNavigation = findViewById(R.id.bottom_bar)

        drawer = findViewById(R.id.lay_drawer)

        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.activityMainNavView.setupWithNavController(navController)

        NavigationUI.setupWithNavController(bottomNavigation, navHostFragment.navController)

        loadPreference()
        toolbar = findViewById(R.id.custom_toolbar)
        fragmentBehaviour()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun showLogo(toolbar: MaterialToolbar) {
        toolbar.title = ""
        binding.toolbarTitle.text = ""
        val logoImageView = binding.toolbarLogo // Reemplaza R.id.logoImageView con el ID real de tu ImageView de logotipo
        logoImageView.visibility = View.VISIBLE // Oculta la imagen del logotipo
    }

    private fun hideLogo(toolbar: MaterialToolbar, title: String){
        toolbar.title = ""
        binding.toolbarTitle.text = title
        val logoImageView = binding.toolbarLogo // Reemplaza R.id.logoImageView con el ID real de tu ImageView de logotipo
        logoImageView.visibility = View.GONE // Oculta la imagen del logotipo

    }

    private fun hideToolbar(toolbar: MaterialToolbar){
        toolbar.visibility = View.GONE
        binding.myAppBarLayout.visibility = View.GONE
    }

    private fun fragmentBehaviour() {
        navController.addOnDestinationChangedListener { _, destination: NavDestination, _ ->
            when (destination.id) {

                R.id.fragSearch -> {
                    val title = "Search Flight"
                    hideLogo(toolbar, title)
                }
                R.id.fragOffers -> {
                    val title = "Offers"
                    hideLogo(toolbar, title)
                }
                R.id.fragTripDetails -> {
                    hideToolbar(toolbar)
                }
                R.id.fragProfile -> {
                    hideToolbar(toolbar)
                }else -> {
                showLogo(toolbar)
                }
            }
        }
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