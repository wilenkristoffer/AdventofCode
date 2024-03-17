package `2022Day1Part2`

import java.io.File

fun toppTre(inputFilePath: String): List<Pair<Int, Int>> {
    val groups = mutableListOf<Pair<Int, Int>>()

    var count = 0
    var currentIndex = 0

    File(inputFilePath).forEachLine { line ->
        if (line.isBlank()) {
            if (count > 0) {
                groups.add(currentIndex to count)
                count = 0
                currentIndex++
            }
        } else {
            val number = line.toIntOrNull()
            if (number != null) {
                count += number
            }
        }
    }

    if (count > 0) {
        groups.add(currentIndex to count)
    }


    val topThreeGroups = groups.sortedByDescending { it.second }.take(3)
    return topThreeGroups
}

fun fåUtTotalen(toppTreGrupp : List<Pair<Int, Int>>) : Int{


 var toppTreTotalt = 0
toppTreGrupp.forEachIndexed { index, (_, sum) ->
        toppTreTotalt += sum  }
    return toppTreTotalt

}

fun main() {
    val inputFilePath = "src/2022Day1/20221201.txt"
    val topThreeGroups = toppTre(inputFilePath)
    val totalen = fåUtTotalen(topThreeGroups)
    println("Tillsammans $totalen")
}