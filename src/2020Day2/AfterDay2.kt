package `2020Day2`

import java.io.File

data class PasswordWithPolicy(val password: String, val range: IntRange, val letter: Char
) {

    fun validatePartOne() =
        password.count { it == letter } in range

    //Del 2
    fun validatePartTwo() =
        //boolean xor = true om operanderna är olika
        (password[range.first - 1] == letter) xor (password[range.last - 1] == letter)

    companion object {
        fun parse(line: String) = PasswordWithPolicy(
            password = line.substringAfter(": "),
            letter = line.substringAfter(" ").substringBefore(":").single(),
            range = line.substringBefore(" ").let {
                val (start, end) = it.split("-")
                start.toInt()..end.toInt()
            },
        )
    }
}

fun main() {
    val passwords = File("src/2020Day2/20201202.txt").readLines().map(PasswordWithPolicy::parse)
    println(passwords.count { it.validatePartOne() })
    println(passwords.count { it.validatePartTwo() })

}