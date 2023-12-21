package com.disusa.gymprogress

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.disusa.gymprogress.fragments.HomeFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_fragment, HomeFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}