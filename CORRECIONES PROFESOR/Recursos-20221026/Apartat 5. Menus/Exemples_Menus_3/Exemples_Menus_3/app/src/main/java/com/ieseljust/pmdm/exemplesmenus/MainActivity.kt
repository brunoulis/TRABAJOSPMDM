package com.ieseljust.pmdm.exemplesmenus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
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

        // Registrem la vista (textViewContext) perquè quan es faça un
        // clic llarg sobre ella es mostre el menú contextual
        registerForContextMenu(binding.textViewContext)
    }


    // Quan es genere un menú contextual sobre una vista
// s'invoca el següent mètode per a crear el menú
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?) {
        //menuInflater.inflate(R.menu.menu_contextual,menu)

        menu?.add(0, 0, 0, R.string.openContext)?.setIcon(android.R.drawable.ic_menu_more);

        // També podem afegir-li una capçalera
        menu?.setHeaderTitle(R.string.contextMenu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    // Com que tenim un menú contextual associat a aquest activitat
    // hem de gestionar les accions a realitzar, mitjanánt onContextItemSelected

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            0 -> {
                val intent = Intent(this, ContextActivity::class.java)
                // Fem que si l'activita estava oberta es porte al front,
                // en lloc de que es cree de nou
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
            }
        }
        return super.onContextItemSelected(item)
    }
}