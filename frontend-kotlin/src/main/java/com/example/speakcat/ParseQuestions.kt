package com.example.speakcat

import java.io.File


fun parseQuestions(filePath: String): List<Question> {
    val fileContent = File(filePath).readText()
    val regex = Regex("""Question\(\s*(\d+),\s*"(.+?)",\s*(\d+),\s*"(.+?)",\s*"(.+?)",\s*"(.+?)",\s*"(.+?)",\s*(\d+)\s*\)""")
    return regex.findAll(fileContent).map {
        val (id, text, image, option1, option2, option3, option4, correctAnswer) = it.destructured
        Question(id.toInt(), text, image.toInt(), option1, option2, option3, option4, correctAnswer.toInt())
    }.toList()
}

fun main() {
    val filePath = "app/src/main/java/com/example/speakcat/Constants.kt"
    val questions = parseQuestions(filePath)
    println(questions.take(10))
}
