package com.ieseljust.brunoluisvazquezpais.apac2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ieseljust.pmdm.apac2.Incidencia
import com.ieseljust.pmdm.apac2.Incidencies

class AdaptadorIncidencias(
    val  eventListenerClick: (Incidencia, View)->Unit,
    val  eventListenerLongClick: (Incidencia, View)->Boolean

): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val vista = inflater.inflate(R.layout.incidencia_layout, parent, false)
        return IncidenciaViewHolder(vista)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as IncidenciaViewHolder).bind(Incidencies.incidencies[position],
            eventListenerClick,
            eventListenerLongClick)



    }

    override fun getItemCount(): Int {
        return Incidencies.incidencies.size
    }

}