package com.ieseljust.apac3brunoluisvazquezpais.model_b;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import  java.io.Serializable;

@Entity
data class Incidencia(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var assumpte: String,
    var descripcio: String,
    var ubicacio: String,
    var servei: String, // Jardineria, Infraestructures, Obres
    var img: Int,
    var resolt: Boolean
): Serializable
