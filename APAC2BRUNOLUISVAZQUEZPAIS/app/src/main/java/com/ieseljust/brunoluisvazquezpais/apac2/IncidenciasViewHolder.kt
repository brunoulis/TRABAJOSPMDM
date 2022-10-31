package com.ieseljust.brunoluisvazquezpais.apac2;

import android.util.Log
import android.view.OrientationEventListener
import android.view.View
import android.widget.ImageView;
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ieseljust.pmdm.apac2.Incidencia

class IncidenciasViewHolder : RecyclerView.ViewHolder (itemView) {
    val image: ImageView = itemView.findViewById(R.id.imageView) as ImageView
    val ide: TextView = itemView.findViewById(R.id.idIncidencia) as TextView

    fun bind(
        incidencia: Incidencia,
        eventListenerClick: (Incidencia,View)->Unit,
        eventListenerLongClick: (Incidencia,View)->Boolean
    ) {
        ide.text = incidencia.id.toString()
        image.setImageResource(incidencia.img)

        //Capturamops los eventos y invocamos al callback correspondiente

        //Click normal
        itemView.setOnClickListener { eventListenerClick(incidencia, itemView)
        }
        //Click largo
        itemView.setOnLongClickListener {
            eventListenerLongClick(incidencia, itemView)
        }
    }





}
