package `2022Day2`

import java.io.File

fun main() {

    val inputFile = File("src/2022Day2/20221202.txt").readLines()

    var totalScore = 0
    for (line in inputFile) {

        val opponentMove = line[0]
        val responseMove = line[2]

        val outcome = calculateOutcome(opponentMove, responseMove)
        val score = calculateScore(responseMove, outcome)
        totalScore += score
    }

    println("$totalScore")

}

   fun calculateOutcome(opponentMove: Char, responseMove: Char): Char {
        return when {
            //Förlorar
                    (opponentMove == 'A' && responseMove == 'Z') ||
                    (opponentMove == 'B' && responseMove == 'X') ||
                    (opponentMove == 'C' && responseMove == 'Y') -> 'L'
            //Lika
                    (opponentMove == 'A' && responseMove == 'X') ||
                    (opponentMove == 'B' && responseMove == 'Y') ||
                    (opponentMove == 'C' && responseMove == 'Z') -> 'D'
            //Vinner
            else -> 'W'
        }
    }

fun calculateScore(responseMove: Char, outcome: Char): Int {
    val responseScore = when (responseMove) {
        'X' -> 1
        'Y' -> 2
        'Z' -> 3
        else -> throw IllegalArgumentException("Invalid response move")
    }

    val outcomeScore = when (outcome) {
        'W' -> 6
        'D' -> 3
        'L' -> 0
        else -> throw IllegalArgumentException("Invalid outcome")
    }

    return responseScore + outcomeScore
}


