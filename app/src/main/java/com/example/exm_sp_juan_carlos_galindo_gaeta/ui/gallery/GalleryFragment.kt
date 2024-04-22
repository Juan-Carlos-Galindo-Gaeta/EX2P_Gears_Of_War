package com.example.exm_sp_juan_carlos_galindo_gaeta.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.exm_sp_juan_carlos_galindo_gaeta.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // Esta propiedad solo es válida entre onCreateView y onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Infla y vincula el diseño del fragmento utilizando ViewBinding
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Obtiene una instancia del ViewModel asociado al fragmento
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        // Obtiene una referencia al TextView del diseño para mostrar datos
        val textView: TextView = binding.textGallery

        // Observa los cambios en los datos del ViewModel y actualiza la UI
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Libera la referencia al binding para evitar memory leaks
        _binding = null
    }
}