package `2020Day1`

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Day1TestAfter{

    @Test
    fun findPairWithSum() {
        val numbers = listOf(1721, 979, 366, 299, 675, 1456)
        val expectedPair = Pair(1721, 299)

        val pair = findPairWithSum(numbers, 2020)
        assertEquals(expectedPair, pair)
    }

    @Test
    fun findTripleWithSum() {
        val numbers = listOf(1721, 979, 366, 299, 675, 1456)
        val expectedTriple = Triple(979, 366, 675)

        val triple = findTripleWithSum(numbers, 2020)
        assertEquals(expectedTriple, triple)
    }
}