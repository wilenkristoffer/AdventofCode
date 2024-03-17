package `2020Day1`

import java.io.File

//Metoder för att kunna jobba testdrivet
fun findPair(data: List<Int>): Pair<Int, Int>? {
    return data.mapNotNull { first ->
        val second = data.find { first + it == 2020 }
        if (second != null) Pair(first, second) else null
    }.firstOrNull()
}

fun findTriplet(data: List<Int>): Triple<Int, Int, Int>? {
    return data.flatMap { first ->
        data.flatMap { second ->
            data.mapNotNull { third ->
                if (first + second + third == 2020) Triple(first, second, third) else null
            }
        }
    }.firstOrNull()
}

fun main() {


    val data: List<Int> =
        File("src/2020Day1/20201201.txt").readLines().mapNotNull { it.toIntOrNull() }


    val pair = findPair(data)
    val triplet = findTriplet(data)

    if(pair != null) {
        println(pair.first * pair.second)

    }
    if (triplet != null)
        println(triplet.first * triplet.second * triplet.third)

}
