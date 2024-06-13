package com.example.speakcat

import java.nio.file.Path
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException
import java.sql.Statement


fun connectToDatabase(dbPath: String): Connection? {
    return try {
        Class.forName("org.sqlite.JDBC")
        DriverManager.getConnection("jdbc:sqlite:$dbPath")
    } catch (e: SQLException) {
        println(e.message)
        null
    } catch (e: ClassNotFoundException) {
        println("SQLite JBC driver not found.")
        null
    }
}

fun createTable(connection: Connection) {
    val createTableSQL = """
        CREATE TABLE IF NOT EXISTS questions (
            id INTEGER PRIMARY KEY,
            text TEXT NOT NULL,
            image INTEGER,
            option1 TEXT NOT NULL,
            option2 TEXT NOT NULL,
            option3 TEXT NOT NULL,
            option4 TEXT NOT NULL,
            correctAnswer INTEGER NOT NULL
        );
       
    """.trimIndent()
    connection.createStatement().use { it.execute(createTableSQL) }
}
fun insertQuestions(connection: Connection, questions: List<Question>) {
    val insertSQL = """
        INSERT INTO questions (id, text, image, option1, option2, option3, option4, correctAnswer)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
    """.trimIndent()

    connection.prepareStatement(insertSQL).use { preparedStatement ->
        for (question in questions) {
            preparedStatement.setInt(0, question.id)
            preparedStatement.setString(1, question.question)
            preparedStatement.setInt(2, question.image)
            preparedStatement.setString(3, question.optionOne)
            preparedStatement.setString(4, question.optionTwo)
            preparedStatement.setString(5, question.optionThree)
            preparedStatement.setString(6, question.optionFour)
            preparedStatement.setInt(7, question.correctAnswer)
            preparedStatement.addBatch()
        }
        preparedStatement.executeBatch()
    }
}

fun main() {
    val dbPath = "app/src/main/res/questions.db"

    val connection = connectToDatabase(dbPath)
    connection?.let {
        createTable(it)

        val filePath = "app/src/main/java/com/example/speakcat/Constants.kt"
        val questions = parseQuestions(filePath)

        insertQuestions(it, questions)

        println("Database creada y preguntas insetadas con exito en $dbPath")
    }
}