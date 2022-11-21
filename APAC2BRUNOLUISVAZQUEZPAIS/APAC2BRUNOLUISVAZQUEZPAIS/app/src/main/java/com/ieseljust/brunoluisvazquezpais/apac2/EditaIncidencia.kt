package com.ieseljust.brunoluisvazquezpais.apac2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.ieseljust.brunoluisvazquezpais.apac2.databinding.ActivityEditaIncidenciaBinding

class EditaIncidencia : AppCompatActivity() {

    private lateinit var binding: ActivityEditaIncidenciaBinding
    private var incidenciaActual: Incidencia? = null

    override fun onCreate(savedInstanceState: Bundle?, ) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditaIncidenciaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Cogemos la informacion del intent (si existe)
        val incidencia: Incidencia? = getIntent().getExtras()?.getSerializable("package com.ieseljust.apac2brunoluisvazquezpais.Incidencia") as Incidencia?

        incidencia?.also { //Si la incidencia no es nulo...

            //Actualizamos la incidencia actual
            incidenciaActual = it

            //(En esta funcio de ambito, it hara referencia a la propio incidencia)

            //Actualizamos la vista de la interfice
            binding.imageView.setImageResource(it.img)

            //Editamos el assunto de la incidencia
            binding.editAssumpteIncidencia.setText(it.assumpte)
            binding.editDescpIncidencia.setText(it.descripcio)
            //Editamos ubicaion de la incidencia
            binding.editUbiIncidencia.setText(it.ubicacio)

            //Editamos el booleano de si esta resuelta o no
            binding.editResoltIncidencia.isChecked = it.resolt
            //Actualizamos el spinner
            //Recorremos los diferentes valores de esta y los comparamos
            //Con el valor guardado. Si coincide, dejamos seleccionado ese valor

            for (i in 0..binding.spinnerServei.adapter.count) {
                if (binding.spinnerServei.adapter.getItem(i).equals(it.servei)) {
                    binding.spinnerServei.setSelection(i)
                    break
                }
            }

        }
        //Capturamos el click sobre el boton de guardar:
        binding.buttonSave.setOnClickListener{
            guardarIncidencia()
        }

    }

    fun guardarIncidencia() {
        //  Cream una nueva incidencia con las informacion de las vistas
        //Llamamos a la funcion de guardar incidencia
        val nou = Incidencia(
            //Obtenemos lla
            incidenciaActual?.id ?: 0,
            binding.editAssumpteIncidencia.text.toString(),
            binding.editDescpIncidencia.text.toString(),
            binding.editUbiIncidencia.text.toString(),
            binding.spinnerServei.selectedItem.toString(),
            incidenciaActual?.img ?: R.drawable.incidencia,
            binding.editResoltIncidencia.isChecked
        
        )
        var incidenciaAct: Incidencia? = nou


        //Añadir la id a guardar el id de la incidencia actual
        //Obtenemos el id de la incidencia anterior
        //y le asignamos el nuevo id sumandole 1


        if (incidenciaActual == null) {
            //Si la incidencia actual es nulo, es que estamos creando una nueva
            //Añadimos la incidencia a la lista
            Incidencies.replace(incidenciaActual!!, nou)
            Snackbar.make(
                (binding.root),
                "Incidencia modificada correctamente",
                Snackbar.LENGTH_LONG
            ).setAction("Close", { finish() }).show()

        } else {
            //Si la incidencia actual no es nulo, es que estamos editando una existente
            //Actualizamos la incidencia en la lista
            Incidencies.add(nou)
            Snackbar.make(
                (binding.root),
                "Incidencia añadida correctamente",
                Snackbar.LENGTH_LONG
            ).setAction("Close", { finish() }).show()
            //Actualizamos la incidencia actual, por si despues queremos editarla
            incidenciaActual = nou
        }
    }
}