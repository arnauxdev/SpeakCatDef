package com.example.speakcat.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private val _playerName = MutableLiveData<String>()
    val playerName: LiveData<String>
        get() = _playerName

    private val _playerScore = MutableLiveData<Int>().apply { value = 0 }
    val playerScore: LiveData<Int>
        get() = _playerScore

    fun setPlayerName(name: String) {
        _playerName.value = name
    }

    fun setPlayerScore(score: Int) {
        Log.d("ScoreViewModel", "Puntuación recibida: $score")
        _playerScore.value = score
        Log.d("ScoreViewModel", "Puntuación actualizada: ${_playerScore.value}")
    }
}
