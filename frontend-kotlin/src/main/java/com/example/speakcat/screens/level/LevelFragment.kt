package com.example.speakcat.screens.level

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        (activity as AppCompatActivity).supportActionBar?.title = "Volver a inicio"
        val userData: UserData? = arguments?.getParcelable("userData")
        val userName = userData?.name ?: "Usuario"

        // Establecer el nombre del usuario en el TextView correspondiente
        binding.welcomeTextView.text = "Hola, $userName ¿Qué nivel quieres hacer hoy?"


        binding.btnStartGame.setOnClickListener {
            val selectedLevel = when (binding.radioGroupLevels.checkedRadioButtonId) {
                R.id.radioBasic -> "Básico"
                R.id.radioIntermediate -> "Intermedio"
                R.id.radioAdvanced -> "Difícil"
                else -> null // Manejar caso por defecto
            }

            if (selectedLevel == null) {
                Toast.makeText(requireContext(), "Por favor, selecciona un nivel", Toast.LENGTH_SHORT).show()
            } else {
                // Crear una instancia de UserData con el nombre y el nivel seleccionados
                val userData = UserData(userName, selectedLevel, 0) // Valores predeterminados para score

                // Crear un Bundle y poner el objeto UserData en él
                val bundle = Bundle().apply {
                    putParcelable("userData", userData)
                }

                // Navegar al fragmento GameFragment con el Bundle
                findNavController().navigate(R.id.action_levelFragment_to_gameFragment, bundle)
            }
        }
    }
}
