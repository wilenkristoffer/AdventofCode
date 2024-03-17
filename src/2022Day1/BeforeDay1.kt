package `2022Day1`

import java.io.File

    fun countMaxSum(inputFilePath: String): Int {
        var maxSum = Int.MIN_VALUE
        var count = 0

        File(inputFilePath).forEachLine { line ->
            if (line.isBlank()) {
                if (count > 0) {
                    if (count > maxSum) {
                        maxSum = count
                    }
                    count = 0
                }
            } else {
                val number = line.toIntOrNull()
                if (number != null) {
                    count += number
                }
            }
        }

        if (count > 0 && count > maxSum) {
            maxSum = count
        }

        return maxSum
    }

    fun main() {
        val inputFilePath = "src/2022Day1/20221201.txt"
        val maxSum = countMaxSum(inputFilePath)
        println("$maxSum")
    }

