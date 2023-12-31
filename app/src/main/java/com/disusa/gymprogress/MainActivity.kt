package com.disusa.gymprogress

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.disusa.gymprogress.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.navigationBars())
        controller.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_fragment, HomeFragment())
        transaction.addToBackStack(null)
        transaction.commit()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.nav_footer)
        bottomNavigation.itemIconTintList = null
        bottomNavigation.itemTextColor = null
        bottomNavigation.itemRippleColor = null
        bottomNavigation.stateListAnimator = null
        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    menuItem.setIcon(R.drawable.home_degrade)
                    bottomNavigation.menu.findItem(R.id.stat)?.setIcon(R.drawable.progress)
                    bottomNavigation.menu.findItem(R.id.calender)?.setIcon(R.drawable.calender_white)
                    bottomNavigation.menu.findItem(R.id.account)?.setIcon(R.drawable.account)
                    bottomNavigation.menu.findItem(R.id.settings)?.setIcon(R.drawable.settings)
                    true
                }
                R.id.stat -> {
                    menuItem.setIcon(R.drawable.progress_degrade)
                    bottomNavigation.menu.findItem(R.id.home)?.setIcon(R.drawable.home_white)
                    bottomNavigation.menu.findItem(R.id.calender)?.setIcon(R.drawable.calender_white)
                    bottomNavigation.menu.findItem(R.id.account)?.setIcon(R.drawable.account)
                    bottomNavigation.menu.findItem(R.id.settings)?.setIcon(R.drawable.settings)
                    true
                }
                R.id.calender -> {
                    menuItem.setIcon(R.drawable.calender_degrade)
                    bottomNavigation.menu.findItem(R.id.stat)?.setIcon(R.drawable.progress)
                    bottomNavigation.menu.findItem(R.id.home)?.setIcon(R.drawable.home_white)
                    bottomNavigation.menu.findItem(R.id.account)?.setIcon(R.drawable.account)
                    bottomNavigation.menu.findItem(R.id.settings)?.setIcon(R.drawable.settings)
                    true
                }
                R.id.account -> {
                    menuItem.setIcon(R.drawable.account_degrade)
                    bottomNavigation.menu.findItem(R.id.stat)?.setIcon(R.drawable.progress)
                    bottomNavigation.menu.findItem(R.id.calender)?.setIcon(R.drawable.calender_white)
                    bottomNavigation.menu.findItem(R.id.home)?.setIcon(R.drawable.home_white)
                    bottomNavigation.menu.findItem(R.id.settings)?.setIcon(R.drawable.settings)
                    true
                }
                R.id.settings -> {
                    menuItem.setIcon(R.drawable.settings_degrade)
                    bottomNavigation.menu.findItem(R.id.stat)?.setIcon(R.drawable.progress)
                    bottomNavigation.menu.findItem(R.id.calender)?.setIcon(R.drawable.calender_white)
                    bottomNavigation.menu.findItem(R.id.account)?.setIcon(R.drawable.account)
                    bottomNavigation.menu.findItem(R.id.home)?.setIcon(R.drawable.home_white)
                    true
                }
                else -> false
            }
        }
    }
}