package com.example.exm_sp_juan_carlos_galindo_gaeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

// Constante para identificar el mensaje extra enviado a la siguiente actividad
const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class CodigoPasarMensaje : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)  // Establece el diseño de la actividad como activity_sp.xml
    }

    // Método invocado al hacer clic en el botón de enviar mensaje
    fun sendMessage(view: View) {
        // Obtiene el texto ingresado en el EditText
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()

        // Crea un Intent para abrir la siguiente actividad (SP) y le pasa el mensaje como extra
        val intent = Intent(this, SP::class.java).apply {
            putExtra(EXTRA_MESSAGE, message) // Agrega el mensaje como extra al intent
        }

        // Inicia la siguiente actividad con el intent creado
        startActivity(intent)
    }
}