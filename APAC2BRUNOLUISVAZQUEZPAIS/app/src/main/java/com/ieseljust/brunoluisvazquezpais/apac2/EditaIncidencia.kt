package com.ieseljust.brunoluisvazquezpais.apac2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.ieseljust.brunoluisvazquezpais.apac2.databinding.ActivityCreateIncidenciaBinding
import com.ieseljust.brunoluisvazquezpais.apac2.databinding.ActivityEditaContacteBinding
import com.ieseljust.brunoluisvazquezpais.apac2.databinding.ActivityEditaIncidenciaBinding
import com.ieseljust.pmdm.apac2.Incidencia
import com.ieseljust.pmdm.apac2.Incidencies

class EditaIncidencia : AppCompatActivity() {

    private lateinit var binding: ActivityEditaIncidenciaBinding
    private var incidenciaActual: Incidencia? = null

    override fun onCreate(savedInstanceState: Bundle?, ) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditaIncidenciaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Cogemos la informacion del intent (si existe)
        val incidencia: Incidencia? = getIntent().getExtras()?.getSerializable("package com.ieseljust.brunoluisvazquezpais.apac2.Incidencia") as Incidencia?

        setContentView(binding.root)

        //Cogemos la informa del intent (si existe)
        val incidencia: Incidencia? = getIntent().getExtras()?.getSerializable("package com.ieseljust.brunoluisvazquezpais.apac2.Incidencia") as Incidencia?

        incidencia?.also { //Si la incidencia no es nulo...

            //Actualizamos la incidencia actual
            incidenciaActual = it

            //(En esta funcio de ambito, it hara referencia a la propio incidencia)

            //Actualizamos la vista de la interfice
            binding.imageViewIncidencia.setImageResource(it.img)
            //Editamos el numero de incidencia
            binding.editIdIncidencia.setText(it.id)
            //Editamos el assunto de la incidencia
            binding.editAssumpteIncidencia.setText(it.assumpte)
            binding.editDescpIncidencia.setText(it.descripcio)
            //Editamos ubicaion de la incidencia
            binding.editUbiIncidencia.setText(it.ubicacio)
            //Editamos el servicio de la incidencia
            binding.editServeiIncidencia.setText(it.servei)
            //Editamos el booleano de si esta resuelta o no
            binding.editResoltIncidencia.setText(it.resolt)
         //Actualizamos el spinner
         //Recorremos los diferentes valores de esta y los comparamos
         //Con el valor guardado. Si coincide, dejamos seleccionado ese valor

            for (i in 0..binding.spinnerPrioritatIncidencia.count) {
                if (binding.spinnerClasse.adapter.getItem(i).equals(it.classe)) {
                    binding.spinnerClasse.setSelection(i)
                    break
                }
            }

        }
        //Capturamos el click sobre el boton de guardar:
        binding.buttonSave.setOnClickListener{
            guardarIncidencia()
        }

    }

    fun guardarIncidencia(){
        //  Cream una nueva incidencia con las informacion de las vistas
        val nou=Incidencia(
            binding.editIdIncidencia.text.toString(),
            binding.spinnerClasse.selectedItem.toString(),
            binding.editAssumpteIncidencia.text.toString(),
            binding.editDescpIncidencia.text.toString(),
            binding.editUbiIncidencia.text.toString(),
            binding.editServeiIncidencia.text.toString(),
            incidenciaActual?.img:0,
            binding.editResoltIncidencia.text.toString())

        if(incidenciaActual==null){
            //Si la incidencia actual es nulo, es que estamos creando una nueva
            //Añadimos la incidencia a la lista
            Incidencies.replace(incidenciaActual!!, nou)
            Snackbar.make((binding.root),
                "Incidencia modificada correctamente",
                Snackbar.LENGTH_LONG).setAction("Close", {finish()}).show()

        }else{
            //Si la incidencia actual no es nulo, es que estamos editando una existente
            //Actualizamos la incidencia en la lista
            Incidencies.add(incidenciaActual!!, nou)
            Snackbar.make((binding.root),
                "Incidencia añadido correctamente",
                Snackbar.LENGTH_LONG).setAction("Close", {finish()}).show()
            incidenciaActual=nou
        }

    }

}