package `2020Day2Part2`

import java.io.File

data class PasswordPolicy(val pos1: Int, val pos2: Int, val char: Char, val password: String)

fun main() {
    val data: List<String> = File("src/2020Day2/20201202.txt").readLines()

    val validPasswords = countValidPasswords(data)
    val invalidPasswords = data.size - validPasswords

println("Valid passwords: $validPasswords")
println("Invalid passwords: $invalidPasswords")
}

fun parseLine(line: String): Pair<PasswordPolicy, String> {
    val parts = line.split(" ")
    val (positions, charWithColon, password) = parts
    val (pos1, pos2) = positions.split("-").map { it.toInt() }
    val char = charWithColon[0] // assuming the char is followed by a colon ":"
    val policy = PasswordPolicy(pos1, pos2, char, password)
    return policy to password
}

fun isPasswordValid(policy: PasswordPolicy, password: String): Boolean {
    val charAtPos1 = password.getOrNull(policy.pos1 - 1)
    val charAtPos2 = password.getOrNull(policy.pos2 - 1)

    return (charAtPos1 == policy.char) xor (charAtPos2 == policy.char)
}

fun countValidPasswords(data: List<String>): Int {
    return data.count { line ->
        val (policy, password) = parseLine(line)
        isPasswordValid(policy, password)
    }
}
