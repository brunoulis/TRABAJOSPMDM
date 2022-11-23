package com.ieseljust.apac3brunoluisvazquezpais.model.db
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface IncidenciaDAO {
    // Metodos de conveniencia

    //Añadir una incidencia
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addIncidencia(incidencia: Incidencia)

    //Borrar una incidencia
    @Delete
    suspend fun deleteIncidencia(incidencia: Incidencia): Int

    //Actualizar una incidencia
    @Update
    suspend fun updateIncidencia(incidencia: Incidencia):

    //Metodos de consulta
    //Obtener la lista de Incidencias
    @Query("SELECT * FROM Incidencia")
    fun getAllIncidencias(): LiveData<List<Incidencia>>
}