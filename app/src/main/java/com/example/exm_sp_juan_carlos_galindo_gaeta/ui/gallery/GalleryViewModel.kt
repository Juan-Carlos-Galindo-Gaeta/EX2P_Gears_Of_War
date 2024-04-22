package com.example.exm_sp_juan_carlos_galindo_gaeta.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    // Mutable live data para almacenar el texto editable
    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment" // Valor inicial del texto
    }

    // LiveData expuesto para que las vistas observen cambios en el texto
    val text: LiveData<String> = _text
}
