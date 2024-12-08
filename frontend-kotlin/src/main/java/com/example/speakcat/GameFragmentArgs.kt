// GameFragmentArgs.kt
package com.example.speakcat

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameFragmentArgs(
    val name: String,
    val level: String
) : Parcelable
