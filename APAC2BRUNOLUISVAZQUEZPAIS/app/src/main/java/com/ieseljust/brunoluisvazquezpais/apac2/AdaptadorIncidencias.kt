package com.ieseljust.brunoluisvazquezpais.apac2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdaptadorIncidencias (
    // Creamos los valores para el adaptador
    //eventListenerclick es el evento que se ejecutará cuando se haga click en un elemento
    //eventListenerlongclick es el evento que se ejecutará cuando se haga click largo en un elemento
    val  eventListenerClick: (Incidencia,View) -> Unit,
    val  eventListenerLongClick: (Incidencia,View) -> Boolean
    
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val vista = inflater.inflate(R.layout.incidencia_layout, parent, false)
        return IncidenciaViewHolder(vista)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as IncidenciaViewHolder).bind(
            Incidencies.incidencies[position],
            eventListenerClick,
            eventListenerLongClick)
    }
    override fun getItemCount(): Int {
        return Incidencies.incidencies.size
    }

}