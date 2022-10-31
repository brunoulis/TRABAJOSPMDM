package com.ieseljust.brunoluisvazquezpais.apac2

import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.ieseljust.brunoluisvazquezpais.apac2.databinding.ActivityCreateIncidenciaBinding
import com.ieseljust.brunoluisvazquezpais.apac2.databinding.ActivityEditaContacteBinding
import com.ieseljust.pmdm.apac2.Incidencia

class EditaContacte : AppCompatActivity() {

    private lateinit var binding: ActivityCreateIncidenciaBinding
    private var incidenciaActual: Incidencia? = null

    override fun onCreate(savedInstanceState: Bundle?, ) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditaContacteBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Cogemos la informacion del intent (si existe)
        val incidencia: Incidencia? = getIntent().getExtras()?.getSerializable("package com.ieseljust.brunoluisvazquezpais.apac2.Incidencia") as Incidencia?

        setContentView(binding.root)

        //Cogemos la informa del intent (si existe)
        val incidencia: Incidencia? = getIntent().getExtras()?.getSerializable("package com.ieseljust.brunoluisvazquezpais.apac2.Incidencia") as Incidencia?

        incidencia?.also { //Si la incidencia no es nulo...

            //Actualizamos la incidencia actual
            incidenciaActual = incidencia
         }

    }

}