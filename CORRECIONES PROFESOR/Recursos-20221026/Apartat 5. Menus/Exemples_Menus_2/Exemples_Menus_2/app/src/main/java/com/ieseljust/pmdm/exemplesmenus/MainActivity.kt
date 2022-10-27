package com.ieseljust.pmdm.exemplesmenus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.ieseljust.pmdm.exemplesmenus.databinding.ActivityMainBinding

// Ara MainActivity ja no deriva de AppCompatActivity
// sinò de ActivityWithMenu
class MainActivity : ActivityWithMenu() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instanciem el binding
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}