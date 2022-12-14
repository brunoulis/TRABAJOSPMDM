package com.ieseljust.brunoluisvazquezpais.apac2

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


//class MyDialogFragment (var title: String, var content: String) : DialogFragment() {

//class MyDialogFragment (var title: String?="aaa", var content: String?="bbb") : DialogFragment() {

class MyDialogFragment():DialogFragment() {

    var title= "Titulo por defecto"
    var content = "Contenido por defecto"

    constructor(title: String, content: String) : this() {
        this.title = title
        this.content = content
    }
    //Definimos la interficie que tendriamos que implementar
    //en la actividad que llame a este fragmento que queremos utilizar
    //esta definido en dos metodos para las que clase que la
    //implemente pueda decidir si implementa uno o los dos

    interface OkOrCancelDialogable {
        fun onPositiveClick()
        fun onCancelClick()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        title=savedInstanceState?.getString("title") ?: title
        content=savedInstanceState?.getString("content") ?: content

        return activity?.let {
            val builder: AlertDialog.Builder=AlertDialog
                .Builder(requireActivity())
            // title i content es defineixen com a propietats de la
            // pròpia classe al constructor primari
            builder.setTitle(title).setMessage(content)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    // Obtenim l'activitat que ha invocat el fragment,
                    // i li fem un càsting com a la interfície OkOrCancelDialogable
                    // L'operador "as" s'anomena "unsafe cast operator", i pot
                    // llançar una exceió si el càsting no és possible.
                    // Invoquem al mètode onPositiveClick implementat per
                    // l'activitat que implementa OkOrCancelDialogable
                    val listener = activity as OkOrCancelDialogable?
                    listener!!.onPositiveClick()
                }
                .setNegativeButton(android.R.string.cancel) { _, _ ->
                    // Invoquem al mètode onPositiveClick implementat per
                    // l'activitat que implementa OkOrCancelDialogable
                    val listener = activity as OkOrCancelDialogable?
                    listener!!.onCancelClick()
                }
            // Retorna un AlertDialog,
            // tal com l'hem definit en el Builder
            return builder.create()} ?: throw IllegalStateException("El fragment no està associat a cap activitat")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("title", title)
        outState.putString("content", content)
    }
}