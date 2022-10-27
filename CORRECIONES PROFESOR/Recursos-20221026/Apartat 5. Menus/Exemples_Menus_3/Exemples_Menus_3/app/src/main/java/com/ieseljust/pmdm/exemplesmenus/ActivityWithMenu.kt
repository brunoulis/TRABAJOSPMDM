package com.ieseljust.pmdm.exemplesmenus

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class ActivityWithMenu:AppCompatActivity() {

    // Aquest objecte acompanyant marcarà en quina activitat estem
    companion object {
        // Definim unes constants internes a l'objecte
        val ACTIVITY_MAIN=0
        val ACTIVITY_SECOND=1
        val ACTIVITY_CONTEXT=3

        var activitatActual=0;
    }

    // Mètode del cicle de vida on es configura el menú d'opcions
    // Android ens proporciona el menú, i nosaltres l'hem d'unflar
    // o modificar amb el contingut que desitgem.
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)

        // Aquest codi recorre el menú, i oculta l'entrada
        // corresponent a l'activitat actual
        for (i in 0 until menu.size()) {
            if (i == activitatActual) menu.getItem(i).isVisible = false
            else menu.getItem(i).isVisible = true
        }

        return true
    }

    // Aquest mètode detecta les opcions que seleccionem al menú
    // i realitza les accions oportines segons l'acció.
    // Abans de llançar cada Intent, actualitzarem l'activitat actual
    // en el companion object.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Determinem l'acció a realitzar segons l'id de l'item
        return when (item.itemId) {
            R.id.goAct1 -> { // Si es tria la primera opció
                activitatActual= ACTIVITY_MAIN
                val intent = Intent(this, MainActivity::class.java)
                // Fem que si l'activita estava oberta es porte al front,
                // en lloc de que es cree de nou
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }
            R.id.goAct2 -> { // Si es tria la segona opció
                activitatActual= ACTIVITY_SECOND
                val intent = Intent(this, SecondActivity::class.java)
                // Fem que si l'activita estava oberta es porte al front,
                // en lloc de que es cree de nou
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }
            // En cas que no coincidisca amb ningun id, invoquem al
            // mètode onOptionsItemSelected d'else
            else -> super.onOptionsItemSelected(item)
        }
    }

    // En primer lloc, definim el mètode
}