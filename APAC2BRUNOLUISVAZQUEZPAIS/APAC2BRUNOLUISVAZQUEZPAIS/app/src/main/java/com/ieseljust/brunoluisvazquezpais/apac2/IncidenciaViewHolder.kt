package com.ieseljust.brunoluisvazquezpais.apac2

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class IncidenciaViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image: ImageView = itemView.findViewById(R.id.imageView) as ImageView
    val assumpte: TextView = itemView.findViewById(R.id.textAssumpte) as TextView
    val descripcio: TextView = itemView.findViewById(R.id.textDescripcio) as TextView

    fun bind(
        incidencia: Incidencia,
        eventListenerClick: (Incidencia,View)->Unit,
        eventListenerLongClick: (Incidencia,View)->Boolean
    ) {
        assumpte.text = incidencia.assumpte
        descripcio.text = incidencia.descripcio
        image.setImageResource(incidencia.img)

        //Capturamops los eventos y invocamos al callback correspondiente

        //Click normal
        itemView.setOnClickListener {
            eventListenerClick(incidencia, itemView)

        }
        //Click largo
        itemView.setOnLongClickListener {
            eventListenerLongClick(incidencia, itemView)
        }
    }


}