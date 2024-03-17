package `2020Day2`

import java.io.File

data class PasswordPolicy(val minCount: Int, val maxCount: Int, val char: Char, val password: String)

fun main() {
    val data: List<String> = File("src/2020Day2/20201202.txt").readLines()

    val validPasswords = countValidPasswords(data)
    val invalidPasswords = data.size - validPasswords

    println("Valid passwords: $validPasswords")
    println("Invalid passwords: $invalidPasswords")
}

fun parseLine(line: String): Pair<PasswordPolicy, String> {
    val parts = line.split(" ")
    val (minMax, charWithColon, password) = parts
    val (minCount, maxCount) = minMax.split("-").map { it.toInt() }
    val char = charWithColon[0]
    val policy = PasswordPolicy(minCount, maxCount, char, password)
    return policy to password
}

fun isPasswordValid(policy: PasswordPolicy, password: String): Boolean {
    val count = password.count { it == policy.char }
    return count in policy.minCount..policy.maxCount
}

fun countValidPasswords(data: List<String>): Int {
    return data.count { line ->
        val (policy, password) = parseLine(line)
        isPasswordValid(policy, password)
    }
}
