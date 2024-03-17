package gears

import java.io.File

//Modifierat PuzzleRunner så vi bara får ut det nödvändiga
class PuzzleRunner {
    fun inputLines(fileName: String = "") = File(fileName).readLines()
}

inline fun <T> puzzle(code: PuzzleRunner.() -> T): T {
    val runner = PuzzleRunner()
    println(runner.code())
    return runner.code()

}
