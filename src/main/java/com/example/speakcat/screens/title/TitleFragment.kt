// TitleFragment.kt
package com.example.speakcat.screens.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.speakcat.R
import com.example.speakcat.databinding.FragmentTitleBinding
import com.example.speakcat.screens.ScoreViewModel
import com.example.speakcat.screens.UserData

class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding
    private val scoreViewModel: ScoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "by ArnauxDev"

        binding.startBtn.setOnClickListener {
            val name = binding.etName.text.toString()
            if (name.isNotEmpty()) {
                // Guardar el nombre del jugador en el ViewModel
                scoreViewModel.setPlayerName(name)

                // Crear una instancia de UserData y pasarla al fragmento de nivel
                val userData = UserData(name = name, level = "", score = 0)
                val bundle = Bundle().apply {
                    putParcelable("userData", userData)
                }
                findNavController().navigate(R.id.action_titleFragment_to_levelFragment, bundle)
            } else {
                Toast.makeText(context, "Por favor ingresa tu nombre", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
