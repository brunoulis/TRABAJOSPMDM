package com.ieseljust.apac3brunoluisvazquezpais.viewmodel;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ieseljust.apac3brunoluisvazquezpais.R;
import com.ieseljust.apac3brunoluisvazquezpais.model.db.Incidencia;

public class AdaptadorIncidencia {
    private val eventListenerClick: (Incidencia) -> Unit,
    private val eventListenerLongClick: (Incidencia) -> Unit
) : RecyclerView.Adapter<ReciclerView.ViewHolder>() {

    }
}
