package `2020Day1`

import java.io.File

fun main() {

    //https://blog.jetbrains.com/kotlin/2021/07/advent-of-code-in-idiomatic-kotlin/


    val numbers = File("src/2020Day1/20201201.txt").readLines().map(String::toInt)

    val pair = findPairWithSum(numbers, 2020)
    println(pair?.let { (a, b) -> a * b })

    val triple = findTripleWithSum(numbers, 2020)
    println(triple?.let { (x, y, z) -> x * y * z })
}


fun findPairWithSum(numbers: List<Int>, sum: Int): Pair<Int, Int>? {
    val complements = numbers.associateBy { sum - it }
    return numbers.mapNotNull { number ->
        val complement = complements[number]
        if (complement != null) Pair(number, complement) else null
    }.firstOrNull()
}

fun findTripleWithSum(numbers: List<Int>, sum: Int): Triple<Int, Int, Int>? {
    return numbers.firstNotNullOfOrNull { x ->
        findPairWithSum(numbers, sum - x)?.let { pair ->
            Triple(x, pair.first, pair.second)
        }
    }

}