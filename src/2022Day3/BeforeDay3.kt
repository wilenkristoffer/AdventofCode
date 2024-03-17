package `2022Day3`

import java.io.File

val data = File("src/2022Day3/20221203.txt").readLines()


fun extractParts(data: List<String>): List<List<Char>> {
    val result = mutableListOf<List<Char>>()

    for (line in data) {
        val partsLength = line.length / 2
        val firstPart = line.substring(0, partsLength).toList()
        val secondPart = line.substring(partsLength).toList()

        val combinedParts = firstPart + secondPart
        result.add(combinedParts)
    }

    return result
}
    //Fungerade inte
  /*  //Funktion för att returnera en char eller null (char?)
    fun findCommonChar(listWParts: List<List<Char>>) : Char? {

        //Plattar ut listan med listor
        return listWParts.flatMap { it }
            //Filtrerar ut chars som förkommer mer än 1 gång
            .filter{ c -> listWParts.flatten().count { it == c } > 1 }
            //Eftersom det bara förekommer chars som är lika 1 gång så tar vi ut den eller sätter
            .distinct().singleOrNull()
    }
   */
    fun findCommonChars(listWParts: List<List<Char>>): List<Char> {
        //Tar fram båda delarna av listan, intersect används för att hitta den gemensamma char'en som finns i båda delarna
        //flatMap för att vi ska få ner det till bara en lista
        return listWParts.flatMap { parts ->
            val part1 = parts.subList(0, parts.size / 2)
            val part2 = parts.subList(parts.size / 2, parts.size)
            part1.intersect(part2).toList()
        }
    }

fun countPriority(commonChars: List<Char>): Int {
    //gör en map som håller prio för alla chars
    val priorityMap = ('a'..'z').zip(1..26).toMap() +
            ('A'..'Z').zip(27..52).toMap()
    //räknar ihop summan av alla chars med prioritets mappen
    return commonChars.sumOf { char -> priorityMap[char] ?: 0 }
}

fun main() {
    val listWithPartOneAndTwoLists = extractParts(data)

    val commonChars = findCommonChars(listWithPartOneAndTwoLists)

    val totalPriority = countPriority(commonChars)

    println("$totalPriority")
}

