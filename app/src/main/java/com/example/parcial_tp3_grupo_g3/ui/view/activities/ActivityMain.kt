package com.example.parcial_tp3_grupo_g3.ui.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
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
import com.example.parcial_tp3_grupo_g3.utils.ToolBarUtils
import com.google.android.material.appbar.MaterialToolbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ActivityMain : AppCompatActivity() {

    lateinit var binding: LayActivityMainBinding
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: MaterialToolbar
    private val fragmentsNavigation = setOf(
        R.id.fragExplore
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbar = findViewById(R.id.custom_toolbar)
        bottomNavigation = findViewById(R.id.bottom_bar)


        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_frag) as NavHostFragment

        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = fragmentsNavigation,
            drawerLayout = binding.activityMainDrawerLayout
        )

        setSupportActionBar(binding.customToolbar)

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.activityMainNavView.setupWithNavController(navController)

        NavigationUI.setupWithNavController(bottomNavigation, navHostFragment.navController)

        loadPreference()
        configureToolbarForFragment()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    //Configura el toolbar para cada fragmento
    private fun configureToolbarForFragment() {
        navController.addOnDestinationChangedListener { _, destination: NavDestination, _ ->
            when (destination.id) {

                R.id.fragSearch -> {
                    val title = "Search Flight"
                    ToolBarUtils.hideLogo(toolbar, title,binding)
                }
                R.id.fragOffers -> {
                    val title = "Offers"
                    ToolBarUtils.hideLogo(toolbar,title,binding)
                }
                R.id.fragTripDetails -> {
                    ToolBarUtils.hideToolbar(toolbar, binding)
                }
                R.id.fragProfile -> {
                    ToolBarUtils.hideToolbar(toolbar, binding)
                }else -> {
                    ToolBarUtils.showLogo(toolbar, binding)
                }
            }
        }
    }

    //Carga las preferencias del usuario
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