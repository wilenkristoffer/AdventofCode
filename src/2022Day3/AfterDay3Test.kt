package `2022Day3`

import junit.framework.TestCase.assertEquals
import org.junit.Test

class testForAfterDay3{

    @Test
    fun testPart1(){
        val listWithData = listOf("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg")
        val expectedResult = 96

        val actualRes = part1(listWithData)

        assertEquals(expectedResult, actualRes)

    }

    @Test
    fun testPart2(){
        val listWithData = listOf("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg")
        val expectedResult = 18

        val actualRes = part2(listWithData)

        assertEquals(expectedResult, actualRes)

    }
}