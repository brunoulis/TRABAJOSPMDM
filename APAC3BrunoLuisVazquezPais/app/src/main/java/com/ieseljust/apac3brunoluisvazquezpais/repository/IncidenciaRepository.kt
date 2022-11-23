package com.ieseljust.apac3brunoluisvazquezpais.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.ieseljust.apac3brunoluisvazquezpais.model.db.Incidencia
import com.ieseljust.apac3brunoluisvazquezpais.model.db.DatabaseBuilder

class IncidenciaRepository (//Constructor primario privado, de manera que no se pueda invocar desde la propia clase
 private var Context: Context){

    companion object {
        private var INSTANCE: IncidenciaRepository? = null
        fun getInstance(context: Context): IncidenciaRepository? {
            if (INSTANCE == null) {
                INSTANCE = IncidenciaRepository(context)
                }
                return INSTANCE!!
            }
    }
    //Aqui se implementan los metodos de la interfaz
    //Añadir una incidencia,borrar una incidencia,actualizar una incidencia y obtener la lista de incidencias
    fun getContactes(): LiveData<List<Incidencia>> {
        return DatabaseBuilder.getInstance(Context)!!.incidenciaDAO().getAllIncidencias()
    }

    suspend fun addIncidencia(incidencia: Incidencia) {
        DatabaseBuilder.getInstance(Context)!!.incidenciaDAO().addIncidencia(incidencia)
    }

    suspend fun deleteIncidencia(incidencia: Incidencia): Int {
        return DatabaseBuilder.getInstance(Context)!!.incidenciaDAO().deleteIncidencia(incidencia)
    }

    suspend fun updateIncidencia(incidencia: Incidencia) {
        DatabaseBuilder.getInstance(Context)!!.incidenciaDAO().updateIncidencia(incidencia)
    }



}