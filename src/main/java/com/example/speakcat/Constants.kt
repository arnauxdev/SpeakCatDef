package com.example.speakcat
import com.example.speakcat.Question

object Constants {
    val basicQuestions = shuffleBasicQuestions()
    val intermediateQuestions = shuffleIntermediateQuestions()
    val advancedQuestions = shuffleAdvancedQuestions()

     fun shuffleBasicQuestions(): ArrayList<Question> {
        val questionsList = arrayListOf<Question>()

         // Preguntas Básicas
         val q1 = Question(
             1, "¿Cómo se dice 'perro' en catalán?",
             0, "Gos", "Gat", "Ocell", "Ratolí", 1
         )
         questionsList.add(q1)

         val q2 = Question(
             2, "¿Qué color tiene el cielo en un día despejado?",
             0, "Verd", "Vermell", "Blau", "Groc", 3
         )
         questionsList.add(q2)

         val q3 = Question(
             3, "¿Cómo se dice 'sol' en catalán?", 0, "Sol", "Estrella", "Lluna", "Núvol", 1
         )
         questionsList.add(q3)

         val q4 = Question(
             4, "Completa la frase: 'Uno, dos, ______'.",
             0, "Número uno", "Número tres", "Número dos", "Número cuatro", 3
         )
         questionsList.add(q4)

         val q5 = Question(
             5, "¿Qué objeto se usa para leer?",
             0, "Casa", "Cotxe", "Llibre", "Arbre", 3
         )
         questionsList.add(q5)

         val q6 = Question(
             6, "¿Cómo se dice 'pato' en catalán?",
             0, "Pa", "Ànec", "Paret", "Paraigües", 2
         )
         questionsList.add(q6)

         val q7 = Question(
             7, "¿Cómo se llama el fenómeno en el que cae agua del cielo?",
             0, "Sol", "Pluja", "Vent", "Nevada", 2
         )
         questionsList.add(q7)

         val q8 = Question(
             8, "Cuando alguien te hace un favor, ¿qué le dices en catalán?",
             0, "Buenos días", "Gràcies", "Adéu", "Fins després", 2
         )
         questionsList.add(q8)

         val q9 = Question(
             9, "¿Qué elemento se utiliza para cocinar y proporciona calor?",
             0, "Aire", "Aigua", "Foc", "Terra", 3
         )
         questionsList.add(q9)

         val q10 = Question(
             10, "¿Cómo se dice 'casa' en catalán?",
             0, "Perro", "Gato", "Casa", "Arbre", 3
         )
         questionsList.add(q10)

         val q11 = Question(
             11, "¿Qué mueble se utiliza para comer?",
             0, "Taula", "Cadira", "Llit", "Estanteria", 1
         )
         questionsList.add(q11)

         val q12 = Question(
             12, "¿Qué fenómeno meteorológico causa visibilidad reducida debido al agua suspendida en el aire?",
             0, "Viento", "Sol", "Nevada", "Boira", 4
         )
         questionsList.add(q12)

         val q13 = Question(
             13, "¿Cómo te mueves de un lugar a otro usualmente?",
             0, "Casa", "Cotxe", "Llibre", "Arbre", 2
         )
         questionsList.add(q13)

         val q14 = Question(
             14, "¿Qué elemento es esencial para la vida y cubre la mayor parte de la superficie de la Tierra?",
             0, "Sol", "Pluja", "Aigua", "Vent", 3
         )
         questionsList.add(q14)

         val q15 = Question(
             15, "¿Cómo se dice 'luna' en catalán?",
             0, "Sol", "Lluna", "Estrella", "Núvol", 2
         )
         questionsList.add(q15)

         val q16 = Question(
             16, "¿Qué estación del año viene después del verano?",
             0, "Tardor", "Primavera", "Hivern", "Estiu", 1
         )
         questionsList.add(q16)

         val q17 = Question(
             17, "¿Qué celebras cuando te reúnes con amigos para divertirte?",
             0, "Festa", "Futbol", "Pilota", "Sopar", 1
         )
         questionsList.add(q17)

         val q18 = Question(
             18, "¿Qué fenómeno atmosférico implica el movimiento del aire?",
             0, "Llúvia", "Sol", "Vent", "Nevada", 3
         )
         questionsList.add(q18)

         val q19 = Question(
             19, "¿Qué haces cuando ingieres alimentos?",
             0, "Menjar", "Beure", "Dormir", "Jugar", 1
         )
         questionsList.add(q19)

         val q20 = Question(
             20, "¿Cómo se dice 'árbol' en catalán?",
             0, "Sol", "Lluna", "Estrella", "Arbre", 4
         )
         questionsList.add(q20)

         questionsList.shuffle()

        return questionsList
    }

     fun shuffleIntermediateQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

         // Preguntas de Nivel B2
         val q1 = Question(
             1, "¿Cuál es el plural correcto de 'ocell' en catalán?",
             0, "Ocells", "Ocell", "Ocelles", "Ocella", 1
         )
         questionsList.add(q1)

         val q2 = Question(
             2, "¿Qué significa 'fer de reüll' en catalán?",
             0, "Hacer de reflejo", "Hacer de tripas corazón", "Hacer de oído", "Hacer de tripas corazón", 3
         )
         questionsList.add(q2)

         val q3 = Question(
             3, "¿Cuál es la traducción correcta de 'esmorzar' al castellano?",
             0, "Almorzar", "Desayunar", "Cenar", "Merendar", 2
         )
         questionsList.add(q3)

         val q4 = Question(
             4, "¿Qué significa 'esbarzer' en catalán?",
             0, "Despertarse", "Espaciar", "Despeinarse", "Desparramar", 4
         )
         questionsList.add(q4)

         val q5 = Question(
             5, "¿Cuál es la traducción correcta de 'tauler' al castellano?",
             0, "Tablero", "Martillo", "Carpintero", "Clavo", 1
         )
         questionsList.add(q5)

         val q6 = Question(
             6, "¿Qué significa 'sibil·la' en catalán?",
             0, "Sibila", "Canción", "Jubilo", "Lamento", 1
         )
         questionsList.add(q6)

         val q7 = Question(
             7, "¿Cuál es la forma verbal correcta del verbo 'prendre' en la tercera persona del singular del subjuntivo presente?",
             0, "Preni", "Prengui", "Prendi", "Prengui", 2
         )
         questionsList.add(q7)

         val q8 = Question(
             8, "¿Qué significa 'pallasso' en castellano?",
             0, "Payaso", "Globo", "Circo", "Saltimbanqui", 1
         )
         questionsList.add(q8)

         val q9 = Question(
             9, "¿Cuál es la traducción correcta de 'presó' al castellano?",
             0, "Presión", "Prisión", "Precisión", "Protección", 2
         )
         questionsList.add(q9)

         val q10 = Question(
             10, "¿Qué significa 'ploure a bots i barrals' en catalán?",
             0, "Llover a cántaros", "Llover a mares", "Llover a raudales", "Llover a baldes", 1
         )
         questionsList.add(q10)

         val q11 = Question(
             11, "¿Cuál es la forma correcta del gerundio del verbo 'morir' en catalán?",
             0, "Morint", "Mort", "Morent", "Mortat", 3
         )
         questionsList.add(q11)

         val q12 = Question(
             12, "¿Qué significa 'amollar' en catalán?",
             0, "Aflojar", "Amoldar", "Asomar", "Arrugar", 1
         )
         questionsList.add(q12)

         val q13 = Question(
             13, "¿Cuál es la traducción correcta de 'pont' al castellano?",
             0, "Ponte", "Puente", "Punta", "Punto", 2
         )
         questionsList.add(q13)

         val q14 = Question(
             14, "¿Qué significa 'trompeta' en castellano?",
             0, "Trompeta", "Trompo", "Trompetero", "Trompetista", 1
         )
         questionsList.add(q14)

         val q15 = Question(
             15, "¿Cuál es la traducción correcta de 'segon' al castellano?",
             0, "Segundo", "Segundo", "Segunda", "Según", 1
         )
         questionsList.add(q15)

         val q16 = Question(
             16, "¿Qué significa 'estel' en catalán?",
             0, "Estrella", "Escarabajo", "Escarlata", "Estela", 1
         )
         questionsList.add(q16)

         val q17 = Question(
             17, "¿Cuál es la traducción correcta de 'guerra' al catalán?",
             0, "Guerre", "Guerra", "Guerre", "Güerra", 2
         )
         questionsList.add(q17)

         val q18 = Question(
             18, "¿Qué significa 'bombolla' en castellano?",
             0, "Bombolla", "Burbuja", "Bombero", "Bombilla", 2
         )
         questionsList.add(q18)

         val q19 = Question(
             19, "¿Cuál es la traducción correcta de 'bresquilla' al castellano?",
             0, "Breza", "Brezco", "Bresca", "Bresquilla", 4
         )
         questionsList.add(q19)

         val q20 = Question(
             20, "¿Qué significa 'cucut' en catalán?",
             0, "Cucurucho", "Cucut", "Cucú", "Cucurucho", 3
         )
         questionsList.add(q20)
         return questionsList
    }

     fun shuffleAdvancedQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

         // Preguntas Avanzadas de Idioma
         val q1 = Question(
             1, "¿Cuál es la diferencia entre 'bastant' y 'bastantíssim' en catalán?",
             0, "Uno es el comparativo de cantidad y el otro es el superlativo",
             "Uno es el comparativo de cantidad y el otro es el comparativo de calidad",
             "Uno es el superlativo y el otro es el comparativo de calidad",
             "Ambos significan lo mismo", 1
         )
         questionsList.add(q1)

         val q2 = Question(
             2, "¿Cuál es la forma correcta del futuro simple en catalán del verbo 'anar' (ir)?",
             0, "Anaré", "Iré", "Andaré", "Iréis", 1
         )
         questionsList.add(q2)

         val q3 = Question(
             3, "¿Cuál es la función de la partícula 'ne' en catalán?",
             0, "Sustituye a un complemento indirecto", "Indica posesión", "Introduce una negación", "Expresa cantidad", 1
         )
         questionsList.add(q3)

         val q4 = Question(
             4, "¿Cuál es el tiempo verbal que se utiliza para expresar acciones futuras en el pasado en catalán?",
             0, "Futuro perfecto", "Condicional compuesto", "Imperfecto de subjuntivo", "Pluscuamperfecto", 4
         )
         questionsList.add(q4)

         val q5 = Question(
             5, "¿Cuál es el pronombre relativo que se utiliza para referirse a una cosa o situación ya mencionada en catalán?",
             0, "Que", "Qui", "El qual", "On", 3
         )
         questionsList.add(q5)

         val q6 = Question(
             6, "¿Cuál es la forma correcta del condicional simple en catalán del verbo 'ser' (ser)?",
             0, "Seria", "Fos", "Seré", "Faria", 1
         )
         questionsList.add(q6)

         val q7 = Question(
             7, "¿Cuál es la diferencia entre 'fora' y 'fòra' en catalán?",
             0, "Una es el adverbio y la otra es la preposición", "Una lleva tilde y la otra no",
             "Una es el adverbio y la otra es la conjunción", "Ambas significan lo mismo", 1
         )
         questionsList.add(q7)

         val q8 = Question(
             8, "¿Qué función gramatical tiene la palabra 'feliçment' en catalán?",
             0, "Adjetivo", "Sustantivo", "Adverbio", "Verbo", 3
         )
         questionsList.add(q8)

         val q9 = Question(
             9, "¿Qué tiempo verbal se utiliza para expresar acciones hipotéticas o irreales en el presente en catalán?",
             0, "Condicional simple", "Condicional compuesto", "Imperfecto de subjuntivo", "Futuro simple", 3
         )
         questionsList.add(q9)

         val q10 = Question(
             10, "¿Cuál es el antónimo de 'mentre' en catalán?",
             0, "Després", "Ja", "Abans", "Tot i que", 3
         )
         questionsList.add(q10)

         val q11 = Question(
             11, "¿Qué función tiene la partícula 'ja' en una oración en catalán?",
             0, "Indica acción futura", "Expresa sorpresa", "Señala una acción ya realizada", "Introduce una negación", 3
         )
         questionsList.add(q11)

         val q12 = Question(
             12, "¿Cuál es el plural correcto de 'pantaló' en catalán?",
             0, "Pantalons", "Pantalóss", "Pantalóes", "Pantalons", 1
         )
         questionsList.add(q12)

         val q13 = Question(
             13, "¿Cuál es la forma correcta del presente de subjuntivo del verbo 'parlar' (hablar) en catalán?",
             0, "Parli", "Parles", "Parlés", "Parlin", 3
         )
         questionsList.add(q13)

         val q14 = Question(
             14, "¿Cuál es el término gramatical para el verbo que acompaña a otro y que indica tiempo, modo, aspecto o voz?",
             0, "Adverbio", "Sustantivo", "Verbo auxiliar", "Pronombre", 3
         )
         questionsList.add(q14)

         val q15 = Question(
             15, "¿Cuál es la función gramatical del pronombre 'me' en la oración 'M'agrada el teu vestit' en catalán?",
             0, "Sujeto", "Complemento directo", "Complemento indirecto", "Adverbio de lugar", 3
         )
         questionsList.add(q15)

         val q16 = Question(
             16, "¿Cuál es el plural correcto de 'llibre' en catalán?",
             0, "Llibrers", "Llibres", "Llibresos", "Llibrís", 2
         )
         questionsList.add(q16)

         val q17 = Question(
             17, "¿Qué tiempo verbal se utiliza para expresar acciones simultáneas en el pasado en catalán?",
             0, "Pretérito perfecto", "Imperfecto", "Pretérito pluscuamperfecto", "Pretérito imperfecto", 4
         )
         questionsList.add(q17)

         val q18 = Question(
             18, "¿Cuál es la forma correcta del gerundio del verbo 'menjar' (comer) en catalán?",
             0, "Menjant", "Menjat", "Menjo", "Menjarà", 1
         )
         questionsList.add(q18)

         val q19 = Question(
             19, "¿Cuál es la función gramatical del pronombre 'te' en la oración 'M'ho vas dir a te' en catalán?",
             0, "Sujeto", "Complemento directo", "Complemento indirecto", "Adverbio de lugar", 2
         )
         questionsList.add(q19)

         val q20 = Question(
             20, "¿Cuál es el plural correcto de 'arbre' en catalán?",
             0, "Arbres", "Arbros", "Arbè", "Arbresos", 1
         )
         questionsList.add(q20)

         questionsList.shuffle()
        return questionsList
    }
}
