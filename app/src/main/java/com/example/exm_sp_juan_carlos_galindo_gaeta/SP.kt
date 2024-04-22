package com.example.exm_sp_juan_carlos_galindo_gaeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)

        Toast.makeText(this, "Se cambió de pantalla correctamente", Toast.LENGTH_SHORT).show()

        // Obtener el mensaje enviado desde MainActivity
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Encontrar el TextView y establecer el mensaje
        val textView = findViewById<TextView>(R.id.tvmensajepasado)
        textView.text = message

        // Busca el botón por su ID
        val btnStartActivity: Button = findViewById(R.id.btnsp)

        // Configura el listener de clics para el botón
        btnStartActivity.setOnClickListener {
            // Crea un intent para iniciar la actividad NDSP
            val intent = Intent(this, NDSP::class.java)
            startActivity(intent)
        }
    }
}