package `2022Day1Part2`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class testForBeforeDay1Part2{

    @Test
    fun testFåUtTotalaVärdetTre(){

        val inputFilePath = "src/2022Day1/20221201TestFil.txt"
        val topThreeGroups = toppTre(inputFilePath)
        val expectedtopTre = 45000

        val ränkaToppTreSumman = fåUtTotalen(topThreeGroups)
        Assertions.assertEquals(expectedtopTre, ränkaToppTreSumman)


    }
}