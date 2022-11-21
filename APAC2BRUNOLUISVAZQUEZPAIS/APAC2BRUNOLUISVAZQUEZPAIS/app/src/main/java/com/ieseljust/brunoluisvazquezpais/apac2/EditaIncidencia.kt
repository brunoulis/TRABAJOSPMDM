package com.ieseljust.brunoluisvazquezpais.apac2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.ieseljust.brunoluisvazquezpais.apac2.databinding.ActivityEditaIncidenciaBinding

class EditaIncidencia : AppCompatActivity() {

    private lateinit var binding: ActivityEditaIncidenciaBinding
    var existeIncidencia:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?, ) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditaIncidenciaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Intentamos obtener una incidencia transferida en el Intent
        val incidenciaTransferida: Incidencia? = getIntent().getExtras()
            ?.getSerializable("objetoIncidencia") as Incidencia?


        //Cogemos la informacion del intent (si existe)
        val incidencia: Incidencia? = getIntent().getExtras()?.getSerializable("package com.ieseljust.apac2brunoluisvazquezpais.Incidencia") as Incidencia?

        incidencia?.also { //Si la incidencia no es nulo...

            //Actualizamos la incidencia actual

            existeIncidencia = true

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
        var textoemergente = ""
        val idImg:Int = this.resources.getIdentifier("incidencia", "drawable", this.packageName)
        //Capturamos el click sobre el boton de guardar:
        binding.buttonSave.setOnClickListener{
            if(existeIncidencia){
                Incidencies.update(
                    Incidencia(
                        incidenciaTransferida!!.id,
                        binding.editAssumpteIncidencia.text.toString(),
                        binding.editDescpIncidencia.text.toString(),
                        binding.editUbiIncidencia.text.toString(),
                        binding.spinnerServei.selectedItem.toString(),
                        idImg,
                        binding.editResoltIncidencia.isChecked
                    )
                )
                textoemergente="Incidencia actualizada"

            }else{
                Incidencies.add(
                    binding.editAssumpteIncidencia.text.toString(),
                    binding.editDescpIncidencia.text.toString(),
                    binding.editUbiIncidencia.text.toString(),
                    binding.spinnerServei.selectedItem.toString(),
                    idImg,
                    binding.editResoltIncidencia.isActivated
                )
                textoemergente="Incidencia creada"

            }
            //Mostramos un mensaje emergente con snackbar
            Snackbar.make(it, textoemergente, Snackbar.LENGTH_LONG).show()

        }

    }


}