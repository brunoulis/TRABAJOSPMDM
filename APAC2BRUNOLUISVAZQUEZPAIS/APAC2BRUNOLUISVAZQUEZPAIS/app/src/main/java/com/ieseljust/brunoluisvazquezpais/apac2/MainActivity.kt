package com.ieseljust.brunoluisvazquezpais.apac2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ieseljust.brunoluisvazquezpais.apac2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //cogemos la lista de incidencies y la transformamos en un lista mutable
    //para poder modificarla y añadir incidencias
    private lateinit var binding: ActivityMainBinding
    private var incidenciaToRemove: Incidencia?=null





    private fun itemClicked(incidencia: Incidencia, v: View) {
        //Creamos un intent para abrir la actividad de edicion
        val intent = Intent(this, EditaIncidencia::class.java).apply{

            putExtra("package com.ieseljust.brunoluisvazquezpais.apac2.Incidencia",incidencia)
        }
        //Iniciamos la actividad
        startActivity(intent)
    }
    private  fun itemLongClicked(incidencia: Incidencia, v: View):Boolean{
        incidenciaToRemove=incidencia
        val myDialog=MyDialogFragment(getString(R.string.askRemoveTitle),getString(R.string.askRemove))
        myDialog.show(supportFragmentManager,"removeDialog")
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Instanciamos el binding con un layoutInflater para poder acceder a los elementos de la vista
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Incidencies.afigDadesInicials(this)
        //Asociamos el layout de la incidencia a la lista
        binding.IncidenciesRecyclerView.layoutManager= LinearLayoutManager(this)
        binding.IncidenciesRecyclerView.setHasFixedSize(true)



        binding.IncidenciesRecyclerView.adapter=AdaptadorIncidencias(
            { incidencia: Incidencia, v: View -> itemClicked(incidencia, v) },
            { incidencia: Incidencia, v: View -> itemLongClicked(incidencia, v)}
        )


        

        


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menuprincipal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.agregarinci -> {
                val intent = Intent(this, EditaIncidencia::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }






}