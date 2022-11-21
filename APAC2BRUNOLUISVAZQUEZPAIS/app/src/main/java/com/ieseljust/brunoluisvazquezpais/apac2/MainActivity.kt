package com.ieseljust.brunoluisvazquezpais.apac2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Asociamos el layout de la incidencia a la lista
        binding.IncidenciesRecyclerView.layoutManager= LinearLayoutManager(this)
        binding.IncidenciesRecyclerView.setHasFixedSize(true)

        binding.IncidenciesRecyclerView.adapter=AdaptadorIncidencias(
            { incidencia: Incidencia, v: View -> itemClicked(incidencia, v) },
            { incidencia: Incidencia, v: View -> itemLongClicked(incidencia, v)}
        )
    }
    override fun onResume() {
            super.onResume()
            //Actualizamos la vista con el recycler view
            binding.IncidenciesRecyclerView.adapter?.notifyDataSetChanged()

    }


}

        

        



