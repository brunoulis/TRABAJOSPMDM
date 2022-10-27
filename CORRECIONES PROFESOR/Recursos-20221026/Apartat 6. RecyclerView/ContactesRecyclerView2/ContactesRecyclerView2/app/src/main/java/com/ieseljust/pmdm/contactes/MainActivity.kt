package com.ieseljust.pmdm.contactes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ieseljust.pmdm.contactes.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // "Unflem" els contactes amb el contingut del JSON
        Contactes.inflate(this, R.raw.contacts)

        // Associem el LayoutManager
        binding.ContactesRecyclerView.layoutManager= LinearLayoutManager(this)
        binding.ContactesRecyclerView.setHasFixedSize(true)
        binding.ContactesRecyclerView.adapter = AdaptadorContactes()



    }
}