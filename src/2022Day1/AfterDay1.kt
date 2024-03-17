package `2022Day1`

//https://github.com/spyroid/puzzles/blob/main/src/aoc/y2022/day1/day1.kt

import gears.puzzle

fun main() {

    //Använder egen funktion från PuzzleRunner
    println("Part1 resultat")
    puzzle { part1(inputLines("src/2022Day1/20221201.txt"), 1) }
    println("Part2 resultat")
    puzzle { part1(inputLines("src/2022Day1/20221201.txt"), 3) }
    println("Test1-resultat ska bli 24000")
    puzzle { part1(inputLines("src/2022Day1/20221201TestFil.txt"), 1) }
    println("Test2-resultat ska bli 45000")
    puzzle { part1(inputLines("src/2022Day1/20221201TestFil.txt"), 3) }
}

fun part1(input: List<String>, count: Int): Int {
    return input.fold(mutableListOf(0)) { acc, s ->
        //Om strängen är tom så skapas ett nytt acc element och plussar på från 0
        if (s.isNotBlank()) acc[acc.lastIndex] = s.toInt() + acc.last() else acc.add(0)
        acc
    }
        .sortedDescending()
        .take(count)
        .sum()
}