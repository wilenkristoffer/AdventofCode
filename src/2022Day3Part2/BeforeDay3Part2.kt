package `2022Day3Part2`

import java.io.File

val data = File("src/2022Day3/20221203.txt").readLines()

fun extractThreeParts(data: List<String>): List<List<List<Char>>> {
    val result = mutableListOf<List<List<Char>>>()
    var group = mutableListOf<List<Char>>()

    for (i in data.indices) {
        val line = data[i]

        val characters = line.toList()

        group.add(characters)

        if (group.size == 3 || i == data.lastIndex) {
            result.add(group.toList())

            group = mutableListOf()
        }
    }

    return result
}

fun findCommonChar(listWithGroups: List<List<List<Char>>>) : List<Char>{

    return listWithGroups.map { group ->
        //toSet tar bort dubbletter i varje del och gör om till ett set
        //Vi använder intersect som i del 1, där vi får fram den gemensamma char som alla i gruppen delar
        val commonCharsInGroup = group.map { part -> part.toSet() }.reduce { acc, chars -> acc intersect chars }
        commonCharsInGroup.toList()
        //Plattar ut listorna så vi bara returnerar en lista
    }.flatten()
}
//Samma som i del 1
fun countPriority(commonChars: List<Char>): Int {
    //gör en map som håller prio för alla chars
    val priorityMap = ('a'..'z').zip(1..26).toMap() +
            ('A'..'Z').zip(27..52).toMap()
    //räknar ihop summan av alla chars med prioritets mappen
    return commonChars.sumOf { char -> priorityMap[char] ?: 0 }
}

fun main() {

    val groupOfThree = extractThreeParts(data)

    val commonCharInGroup = findCommonChar(groupOfThree)

    val totalPriority = countPriority(commonCharInGroup)

    println("$totalPriority")

}