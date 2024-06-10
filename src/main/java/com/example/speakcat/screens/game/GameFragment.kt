package com.example.speakcat.screens.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.speakcat.Constants
import com.example.speakcat.Question
import com.example.speakcat.R
import com.example.speakcat.databinding.FragmentGameBinding
import com.example.speakcat.screens.ScoreViewModel
import com.example.speakcat.screens.UserData
import androidx.appcompat.app.AppCompatActivity

class GameFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentGameBinding
    private lateinit var mQuestionsList: ArrayList<Question>
    private var mCurrentPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    // Obtener una instancia de ScoreViewModel asociada con la actividad
    private val playerViewModel: ScoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Vuelve a niveles"

        val userData = arguments?.getParcelable<UserData>("userData")
        val level = userData?.level ?: ""
        mQuestionsList = when (level) {
            "Básico" -> Constants.shuffleBasicQuestions()
            "Intermedio" -> Constants.shuffleIntermediateQuestions()
            "Avanzado" -> Constants.shuffleAdvancedQuestions()
            else -> arrayListOf()
        }

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

        setNextQuestion()

        return binding.root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_optionOne -> selectOption(1)
            R.id.tv_optionTwo -> selectOption(2)
            R.id.tv_optionThree -> selectOption(3)
            R.id.tv_optionFour -> selectOption(4)
            R.id.btnSubmit -> submitAnswer()
        }
    }

    private fun setNextQuestion() {
        // Habilita los clics en las opciones para la próxima pregunta
        binding.tvOptionOne.isClickable = true
        binding.tvOptionTwo.isClickable = true
        binding.tvOptionThree.isClickable = true
        binding.tvOptionFour.isClickable = true
        // Deshabilita el clic en el botón de envío hasta que el usuario seleccione una opción
        binding.btnSubmit.isClickable = false

        clearOptionSelection() // Limpiar la selección de opciones
        if (mCurrentPosition < mQuestionsList.size && mCurrentPosition < 10) {
            mCurrentPosition++
            val question = mQuestionsList[mCurrentPosition - 1]
            setCurrentQuestion(question)
            updateProgress()
        } else {
            navigateToScoreFragment()
        }
    }

    private fun setCurrentQuestion(question: Question) {
        binding.tvQuestion.text = question.question
        binding.imageView.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour
    }

    private fun selectOption(selectedOption: Int) {
        val question = mQuestionsList[mCurrentPosition - 1]
        question.userSelectedAnswer = selectedOption // Actualiza la respuesta seleccionada por el usuario en el objeto Question

        if (selectedOption == question.correctAnswer) {
            mCorrectAnswers++
            setOptionBackground(selectedOption, R.drawable.correct_option_border_bg)
        } else {
            setOptionBackground(selectedOption, R.drawable.wrong_option_border_bg)
            setOptionBackground(question.correctAnswer, R.drawable.correct_option_border_bg)
        }

        // Deshabilita los clics en las opciones después de que el usuario ha seleccionado una respuesta
        binding.tvOptionOne.isClickable = false
        binding.tvOptionTwo.isClickable = false
        binding.tvOptionThree.isClickable = false
        binding.tvOptionFour.isClickable = false
        // Habilita el clic en el botón de envío
        binding.btnSubmit.isClickable = true
    }

    private fun setOptionBackground(option: Int, backgroundResource: Int) {
        when (option) {
            1 -> binding.tvOptionOne.background = ContextCompat.getDrawable(requireContext(), backgroundResource)
            2 -> binding.tvOptionTwo.background = ContextCompat.getDrawable(requireContext(), backgroundResource)
            3 -> binding.tvOptionThree.background = ContextCompat.getDrawable(requireContext(), backgroundResource)
            4 -> binding.tvOptionFour.background = ContextCompat.getDrawable(requireContext(), backgroundResource)
        }
    }

    private fun submitAnswer() {
        // Verificar si se ha seleccionado alguna opción
        if (!isOptionSelected()) {
            // Mostrar un mensaje pidiendo al usuario que seleccione una respuesta
            Toast.makeText(requireContext(), "Por favor, seleccione una respuesta.", Toast.LENGTH_SHORT).show()
            return
        }
        setNextQuestion()
    }

    private fun isOptionSelected(): Boolean {
        val question = mQuestionsList[mCurrentPosition - 1]
        return question.userSelectedAnswer != 0
    }

    private fun navigateToScoreFragment() {
        val score = mCorrectAnswers
        Log.d("GameFragment", "Puntuación del jugador: $score")
        playerViewModel.setPlayerScore(score) // Actualizar el puntaje en el ScoreViewModel
        findNavController().navigate(R.id.action_gameFragment_to_scoreFragment)
    }

    private fun updateProgress() {
        val progress = "${mCurrentPosition}/${10}"
        binding.tvProgress.text = progress
        binding.pb.progress = mCurrentPosition
    }

    private fun clearOptionSelection() {
        binding.tvOptionOne.background = ContextCompat.getDrawable(requireContext(), R.drawable.default_option_border_bg)
        binding.tvOptionTwo.background = ContextCompat.getDrawable(requireContext(), R.drawable.default_option_border_bg)
        binding.tvOptionThree.background = ContextCompat.getDrawable(requireContext(), R.drawable.default_option_border_bg)
        binding.tvOptionFour.background = ContextCompat.getDrawable(requireContext(), R.drawable.default_option_border_bg)
    }
}
