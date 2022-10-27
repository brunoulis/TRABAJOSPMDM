package com.ieseljust.brunoluisvazquezpais.apac2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ieseljust.pmdm.apac2.Incidencia
import com.ieseljust.pmdm.apac2.Incidencies

class MainActivity : AppCompatActivity() {
//cogemos la lista de incidencies y la transformamos en un lista mutable
    //para poder modificarla y añadir incidencias
    private var incidencies:MutableList<Incidencia> = Incidencies.incidencies.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}