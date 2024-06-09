package com.example.speakcat.screens.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.speakcat.R
import com.example.speakcat.screens.ScoreViewModel
import androidx.fragment.app.activityViewModels
import androidx.appcompat.app.AppCompatActivity


class ScoreFragment : Fragment() {

    private val viewModel: ScoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_score, container, false)

        val displayResultTextView: TextView = rootView.findViewById(R.id.displayResult)
        val playerNameTextView: TextView = rootView.findViewById(R.id.playerName) // Añade un TextView para el nombre del jugador
        val playAgainButton: Button = rootView.findViewById(R.id.playAgain)

        // Ocultar la flecha de retroceso en la barra de herramientas
        requireActivity().actionBar?.setDisplayHomeAsUpEnabled(false)

        // Establecer un título personalizado en la barra de herramientas
        (activity as AppCompatActivity).supportActionBar?.title = "App by ArnauxDev"


        viewModel.playerName.observe(viewLifecycleOwner) { name ->
            playerNameTextView.text = "$name"
        }
        // Observar la puntuación y el nombre desde el ViewModel
        viewModel.playerScore.observe(viewLifecycleOwner) { score ->
            displayResultTextView.text = "Has obtenido $score puntos de 10 posibles."
        }


        playAgainButton.setOnClickListener {
            findNavController().navigate(R.id.action_scoreFragment_to_titleFragment)
        }

        return rootView
    }
}
