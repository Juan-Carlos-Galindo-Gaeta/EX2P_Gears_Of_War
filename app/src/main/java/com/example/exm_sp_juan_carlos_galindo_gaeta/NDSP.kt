package com.example.exm_sp_juan_carlos_galindo_gaeta

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.exm_sp_juan_carlos_galindo_gaeta.databinding.ActivityNdspBinding
import com.google.android.material.navigation.NavigationView

class NDSP : AppCompatActivity() {

    // Declaraciones de propiedades
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNdspBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla la vista y la configura como la vista principal
        binding = ActivityNdspBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura la barra de herramientas como la ActionBar
        setSupportActionBar(binding.appBarNdsp.toolbar)

        // Obtiene referencias a elementos de la interfaz de usuario
        val drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_ndsp)

        // Define los ID de los fragmentos que deseas controlar en la navegación
        val fragmentIds = setOf(
            R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
        )

        // Configura el AppBarConfiguration con los fragmentos y el DrawerLayout
        appBarConfiguration = AppBarConfiguration(fragmentIds, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Agrega un listener al NavigationView para controlar los cambios de fragmento
        navView.setNavigationItemSelectedListener { menuItem ->
            val destinationId = menuItem.itemId
            if (fragmentIds.contains(destinationId)) {
                // Muestra un Toast con el mensaje de cambio de pantalla
                val message = "Se cambió de pantalla"
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

                // Realiza la navegación al fragmento seleccionado
                navController.navigate(destinationId)
                true
            } else {
                false
            }
        }
    }

    // Crea el menú de opciones en la barra de herramientas
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.n_d_s, menu)
        return true
    }

    // Maneja la navegación hacia arriba desde la ActionBar
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_ndsp)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    // Maneja el comportamiento del botón de retroceso
    override fun onBackPressed() {
        val drawerLayout = binding.drawerLayout
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}