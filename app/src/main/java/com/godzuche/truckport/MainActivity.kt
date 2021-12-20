package com.godzuche.truckport

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
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

        // Set the title to empty string
        title = ""

        // Set orientation to portrait
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val toolbar = binding.appBarMain.toolbarMain
        setSupportActionBar(toolbar)
        bottomNavigationView = binding.bottomNavView

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val topLevelDestinations = setOf(R.id.loginFragment,
            R.id.signUpFragment,
            R.id.userRegistrationFragment,
            R.id.welcomeFragment,
            R.id.customerDashboardFragment,
            R.id.onboardingFragment)
        val appBarConfiguration = AppBarConfiguration(topLevelDestinations)
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)

//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.onboardingFragment -> {
                    hideNavBar()
                    hideTopAppBar()
                }
                R.id.signUpFragment -> {
//                    hideNavBar()
                    showTopAppBar()
                }
                R.id.loginFragment -> {
                    hideNavBar()
                    showTopAppBar()
                }
                R.id.otpVerificationFragment -> {
//                    hideNavBar()
                    showTopAppBar()
                }
                R.id.userRegistrationFragment -> {
//                    hideNavBar()
                    showTopAppBar()
                }
                R.id.welcomeFragment -> {
//                    hideNavBar()
                    hideTopAppBar()
                }
                R.id.customerDashboardFragment -> {
                    showNavBar()
                    hideTopAppBar()
                }
                R.id.bikeDeliveryFragment -> {
                    hideNavBar()
                    showTopAppBar()
                }
                else -> {
                    showTopAppBar()
                    showNavBar()
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun showTopAppAndStatusBar() {
        showTopAppBar()
        showStatusBar()
    }

    private fun hideTopAppAndStatusBar() {
        hideTopAppBar()
        hideStatusBar()
    }

    private fun showNavBar() {
        bottomNavigationView.visibility = View.VISIBLE
    }

    private fun hideNavBar() {
        bottomNavigationView.visibility = View.GONE
    }

    private fun showTopAppBar() {
        binding.appBarMain.toolbarMain.visibility = View.VISIBLE
    }

    private fun hideTopAppBar() {
        binding.appBarMain.toolbarMain.visibility = View.GONE
    }

    private fun hideStatusBar() {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    private fun showStatusBar() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

}