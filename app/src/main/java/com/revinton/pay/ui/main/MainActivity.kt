package com.revinton.pay.ui.main

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.revinton.pay.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavController()
    }

    private fun initNavController() {

        findNavController(R.id.nav_host_fragment).let { navController ->
            bottom_navigation.setupWithNavController(navController)
            toolbar.setupWithNavController(
                navController,
                AppBarConfiguration(findNavController(R.id.nav_host_fragment).graph)
            )

            navController.addOnDestinationChangedListener { _, destination, _ ->
                bottom_navigation.visibility = View.VISIBLE
                when (destination.id) {
                    R.id.places -> toolbar.visibility = View.GONE
                    R.id.favorites -> toolbar.visibility = View.GONE
                    R.id.notifications -> toolbar.visibility = View.GONE
                    R.id.profile -> toolbar.visibility = View.GONE
                    R.id.reservations -> toolbar.visibility = View.GONE
                    R.id.createReservationFragment -> {
                        bottom_navigation.visibility = View.GONE
                        toolbar.visibility = View.VISIBLE
                        toolbar.title = getString(R.string.reservation)
                    }
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }
}