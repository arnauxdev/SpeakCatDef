package com.example.speakcat.screens.level

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.speakcat.R
import com.example.speakcat.databinding.FragmentLevelBinding
import com.example.speakcat.screens.UserData

class LevelFragment : Fragment() {

    private lateinit var binding: FragmentLevelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Vuelve a la pantalla de inicio"

        binding.btnStartGame.setOnClickListener {
            val selectedLevel = when (binding.radioGroupLevels.checkedRadioButtonId) {
                R.id.radioBasic -> "Básico"
                R.id.radioIntermediate -> "Intermedio"
                R.id.radioAdvanced -> "Avanzado"
                else -> "" // Manejar caso por defecto
            }

            // Crear una instancia de UserData con el nivel seleccionado
            val userData = UserData("NombrePorDefecto", selectedLevel, 0) // Valores predeterminados para name y score

            // Crear un Bundle y poner el objeto UserData en él
            val bundle = Bundle().apply {
                putParcelable("userData", userData)
            }

            // Navegar al fragmento GameFragment con el Bundle
            findNavController().navigate(R.id.action_levelFragment_to_gameFragment, bundle)
        }
    }
}
