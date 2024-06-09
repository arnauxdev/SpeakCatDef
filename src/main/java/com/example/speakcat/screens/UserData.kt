package com.example.speakcat.screens

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    val name: String,
    val level: String,
    val score: Int // Nueva propiedad para almacenar la puntuación del usuario

) : Parcelable
