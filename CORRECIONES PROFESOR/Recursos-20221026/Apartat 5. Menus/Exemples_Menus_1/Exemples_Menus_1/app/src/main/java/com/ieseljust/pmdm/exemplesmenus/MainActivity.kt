package com.ieseljust.pmdm.exemplesmenus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.ieseljust.pmdm.exemplesmenus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instanciem el binding
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // Mètode del cicle de vida on es configura el menú d'opcions
    // Android ens proporciona el menú, i nosaltres l'hem d'unflar
    // o modificar amb el contingut que desitgem.
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    // Aquest mètode detecta les opcions que seleccionem al menú
    // i realitza les accions oportines segons l'acció.

    // Problemes:
    // - El menú només es troba en l'activitat principal
    // - Des d'aquesta activitat permet obrir una altra instància
    //   de la pròpia activitat.
    // Solució:
    // - Crearem una nova classe Activitat entre les nostres activitats
    //   i AppCompatActivity, que gestione els menús, i controle
    //  on estem cada vegada.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Determinem l'acció a realitzar segons l'id de l'item
        return when (item.itemId) {
            R.id.goAct1 -> { // Si es tria la primera opció
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.goAct2 -> { // Si es tria la segona opció
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
                true
                true
            }
            // En cas que no coincidisca amb ningun id, invoquem al
            // mètode onOptionsItemSelected d'else
            else -> super.onOptionsItemSelected(item)
        }
    }
}