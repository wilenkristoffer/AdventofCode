package `2022Day2Part2`

import java.io.File

fun main() {

    val inputFile = File("src/2022Day2/20221202.txt").readLines()

    var totalScore = 0
    for (line in inputFile) {
        val opponentMove = line[0]
        val desiredOutcome = line[2]

        val responseMove = determineResponse(opponentMove, desiredOutcome)

        val outcome = calculateOutcome(opponentMove, responseMove)

        val score = calculateScore(responseMove, outcome)
        totalScore += score
    }

    println("$totalScore")
}

fun determineResponse(opponentMove: Char, desiredOutcome: Char): Char {
    return when (desiredOutcome) {
        //Z Vinner
        'Z' -> when (opponentMove) {
            'A' -> 'Y'
            'B' -> 'Z'
            'C' -> 'X'
            else -> throw IllegalArgumentException("Invalid opponent move")
        }
        //Y Lika
        'Y' -> when (opponentMove) {
            'A' -> 'X'
            'B' -> 'Y'
            'C' -> 'Z'
            else -> throw IllegalArgumentException("Invalid opponent move")
        }
        //X Förlorar
        'X' -> when (opponentMove) {
            'A' -> 'Z'
            'B' -> 'X'
            'C' -> 'Y'
            else -> throw IllegalArgumentException("Invalid opponent move")
        }
        else -> throw IllegalArgumentException("Invalid desired outcome")
    }
}

fun calculateOutcome(opponentMove: Char, responseMove: Char): Char {
    return when {
        opponentMove == 'A' && responseMove == 'Z' -> 'L'
        opponentMove == 'B' && responseMove == 'X' -> 'L'
        opponentMove == 'C' && responseMove == 'Y' -> 'L'

        opponentMove == 'A' && responseMove == 'X' -> 'D'
        opponentMove == 'B' && responseMove == 'Y' -> 'D'
        opponentMove == 'C' && responseMove == 'Z' -> 'D'


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
