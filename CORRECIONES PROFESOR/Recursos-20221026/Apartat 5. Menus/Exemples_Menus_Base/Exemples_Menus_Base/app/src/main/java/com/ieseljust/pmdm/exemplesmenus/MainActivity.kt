package com.ieseljust.pmdm.exemplesmenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ieseljust.pmdm.exemplesmenus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instanciem el binding
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}