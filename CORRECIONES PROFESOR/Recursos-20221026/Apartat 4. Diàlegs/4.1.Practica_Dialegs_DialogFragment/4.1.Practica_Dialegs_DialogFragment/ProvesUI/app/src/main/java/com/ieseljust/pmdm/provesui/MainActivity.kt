package com.ieseljust.pmdm.provesui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.snackbar.Snackbar
import com.ieseljust.pmdm.provesui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyDialogFragment.OkOrCancelDialogable {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Preparant la UI
        populateSpinner()

        // Creem el canal de notificacions
        // En principi, només cal crear-lo una vegada
        creaCanalNotificacions()

        // Gestió d'events
        binding.button.setOnClickListener {
            Log.d("Prova", binding.PlainText.text.toString())
            Log.d("Prova", binding.editTextTextPassword.text.toString())
            Log.d("Prova", if (binding.checkBox.isChecked) "activat" else "desactivat" )
            //val myDialog = MyDialogFragment("Confirmació",  "¿Esteu segurs que desitgeu guardar les dades?")
            //myDialog.show(supportFragmentManager, "myDialog")
        }


    }

    // Métodes per a la interfície
    private fun populateSpinner() {
        // Creem un ArrayAdapter a partir d'un recurs de tipus array
        // Requereix tres paràmetres: El context, el recurs, i el
        // disseny de l'entrada (utilitzarem el proporcionat per la
        // pròpia plataforma.
        val spinner: Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.mesos,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            // Si tenim l'adaptador preparat, seleccionem el disseny
            // per a la llista d'opcions (el proporciona per la plataforma)
            adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_item)
                //android.R.layout.simple_spinner_item)
            // I finalment, afegim l'adaptador al spinner
                spinner.adapter = adapter
        }
    }


    // Apartat 3. Notificacions
    private fun creaCanalNotificacions() {
        // Creem el canal de notificacions només si
        // ens trobem en un nivell d'API 26+

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Definim les propietats del canal: nom,
            // descripció i importància
            val nom = "Canal de prova"
            val descripcio = "Descripció del meu canal"
            val importancia = NotificationManager.IMPORTANCE_HIGH

            // Creem el canal amb NotificationChannel
            // El constructor rep la cadena amb l'ID, el nom
            // i la imporancia.
            // Una vegada creat, utilitzarem la funció d'àmbit apply sobre ell,
            // mitjançant la qual, assignem la descripció a aquest canal.

            val canal = NotificationChannel("EL_MEU_CANAL", nom, importancia)
                .apply {
                    description = descripcio
                }

            // I finalment es registra el canal en el sistema mitjançant
            // el servei de notificacions del sistema de la següent manera:
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE)
                        as NotificationManager
            notificationManager.createNotificationChannel(canal)
        }
    }

    override fun onPause() {
        super.onPause()
        // creaNotificacio()

    }

    fun creaNotificacio(){

        // Preparem l'ID del canal per a la notificació
        var CHANNEL_ID = "EL_MEU_CANAL"

        // Preparem una Intent explícita per a l'activitat
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        // I el Pending Intent, a partir d'aquest, que le proporcionarem
        // al sistema de notificacions
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        // Creem la notificació, proporcionant-li un context i l'ID del canal
        // i li afegim totes les propietats necessàries

        var builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(androidx.appcompat.R.drawable.btn_checkbox_checked_mtrl)
            .setContentTitle("Títol de la notificació") // Títol
            .setContentText("Contingut de la notificació") // Text
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) // Prioritat
            .setContentIntent(pendingIntent) // Acció a fer clic
            .setAutoCancel(true) // Perquè desaparega la notificació



        val ID_Notificacion=0
        with(NotificationManagerCompat.from(applicationContext)) {
            notify(ID_Notificacion, builder.build())
        }
    }

    override fun onPositiveClick() {
        Snackbar.make(
            binding.root,
            "S'han guardat les dades",
            Snackbar.LENGTH_LONG)
            .show()
    }

    override fun onCancelClick() {
        Toast.makeText(
            applicationContext,
            "S'ha cancel·lat l'acció",
            Toast.LENGTH_SHORT)
            .show()
    }
}




