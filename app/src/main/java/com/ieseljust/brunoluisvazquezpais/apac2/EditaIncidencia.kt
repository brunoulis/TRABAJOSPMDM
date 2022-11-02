package com.ieseljust.brunoluisvazquezpais.apac2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.ieseljust.brunoluisvazquezpais.apac2.databinding.ActivityEditaIncidenciaBinding

class EditaIncidencia : AppCompatActivity() {
    private lateinit var binding: ActivityEditaIncidenciaBinding
    private var incidenciaActual: Incidencia? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditaIncidenciaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Cogemos la informacion del intent (si existe)
        val incidencia: Incidencia? = getIntent().getExtras()?.getSerializable("package com.ieseljust.brunoluisvazquezpais.apac2.Incidencia") as Incidencia?



        }
}