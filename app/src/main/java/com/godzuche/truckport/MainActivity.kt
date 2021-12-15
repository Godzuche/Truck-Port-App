package com.godzuche.truckport

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.godzuche.truckport.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        installSplashScreen()
        setContentView(view)

        // Set orientation to portrait
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val toolbar = binding.appBarMain.toolbarMain
        setSupportActionBar(toolbar)
        bottomNavigationView = binding.bottomNavView

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val topLevelDestinations = setOf(R.id.loginFragment, R.id.signUpFragment)
        val appBarConfiguration = AppBarConfiguration(topLevelDestinations)
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.onboardingFragment -> hideTopAppAndStatusBar()
                R.id.signUpFragment -> {
                    showTopAppAndStatusBar()
                    hideStatusBar()
                }
                R.id.loginFragment -> {
                    showTopAppAndStatusBar()
                    hideStatusBar()
                }
                else -> showTopAppAndStatusBar()
            }
        }
    }

    private fun showTopAppAndStatusBar() {
        binding.appBarMain.toolbarMain.visibility = View.VISIBLE
        bottomNavigationView.visibility = View.VISIBLE
        showStatusBar()
    }

    private fun hideTopAppAndStatusBar() {
        binding.appBarMain.toolbarMain.visibility = View.GONE
        bottomNavigationView.visibility = View.GONE
        hideStatusBar()
    }

    private fun hideStatusBar() {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    private fun showStatusBar() {
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

}