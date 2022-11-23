package com.ieseljust.apac3brunoluisvazquezpais.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Incidencia::class], version = 1, )
abstract class IncidenciasDB : RoomDatabase() {
    abstract fun incidenciaDAO(): IncidenciaDAO
}
object DatabaseBuilder {
    private var INSTANCE: IncidenciasDB? = null
    fun getInstance(context: Context): IncidenciasDB? {
        if (INSTANCE == null) {
            synchronized(IncidenciasDB::class) {
                INSTANCE = buidRoomDB(context)
            }
        }
        return INSTANCE!!
    }
    // Constructor privat
    private  fun buidRoomDB(context: Context) =
        Room.databaseBuilder(context.applicationContext,
            IncidenciasDB::class.java,
            "incidencias.db").build()
}
