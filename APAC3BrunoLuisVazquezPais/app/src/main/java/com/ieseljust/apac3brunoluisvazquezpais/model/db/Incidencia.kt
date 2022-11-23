package com.ieseljust.apac3brunoluisvazquezpais.model.db

import java.io.Serializable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Incidencia(
    @PrimaryKey(autoGenerate = true)var id:Long = 0,
    var nom:String,
    var descripcio: String?,
    var img: Int,
    var data: String?,
    var hora:String?
): Serializable
