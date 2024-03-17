package `2022Day3`

import java.io.File

//https://www.reddit.com/r/adventofcode/comments/zb865p/comment/iyt4ygk/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button

val input = File("src/2022Day3/20221203.txt").readLines()

//Använder en metod i en annan metod
//it.chunked delar upp alla rader i listan och sen delar de på 2
fun part1(lines: List<String>):Int = sumPriority(lines.map{it.chunked(it.length/2)})

fun part2(lines: List<String>):Int = sumPriority(lines.chunked(3))

fun Char.priority(): Int = 1 + if (isUpperCase()) this - 'A' + 26 else this - 'a'

//Får in en lista med en lista på strängar, .first tar den char som matchar då vi bara har en.
//.drop(1) tar bort den första strängen eftersom vi inte behöver den längre,
// sen kollar den ifall resten av strängarna i gruppen innehåller den char(c) vi har från första strängen
//Därefter kallas priority som lämnar ifrån sig en int med rätt värde för den char vi hittade
fun sumPriority(groups: List<List<String>>): Int = groups
    .sumOf{ it[0].first { c -> it.drop(1)
        .all { l -> l.contains(c) } }.priority() }

fun main() {

    println(part1(input))

    println(part2(input))

}