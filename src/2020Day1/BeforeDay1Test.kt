package `2020Day1`

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day1TestBefore {

    //Testdata från AoC

    @Test
    fun hittaPar() {
        val testData = listOf(1721, 979, 366, 299, 675, 1456)
        val expectedPair = Pair(1721, 299)

        val pair = findPair(testData)
        assertEquals(expectedPair, pair)
    }

    @Test
    fun hittaTrippel() {
        val testData = listOf(1721, 979, 366, 299, 675, 1456)
        val expectedTriplet = Triple(979, 366, 675)

        val triplet = findTriplet(testData)
        assertEquals(expectedTriplet, triplet)
    }
}