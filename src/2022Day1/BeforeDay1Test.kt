package `2022Day1`

import org.junit.Test
import junit.framework.TestCase.assertEquals


class TestBeforeDay1{

    @Test
    fun testRäknaIhop(){

        val numbers = "src/2022Day1/20221201TestFil.txt"
        val expectedMax = 24000

        val ränkaMaxSumman = countMaxSum(numbers)
        assertEquals(expectedMax, ränkaMaxSumman)
    }
}