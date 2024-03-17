package `2022Day3`

import junit.framework.TestCase.assertEquals
import org.junit.Test

class testForBeforeDay3{

    @Test
    fun testExtractedParts(){
        val listWData = listOf("vJrwpWtwJgWrhcsFMMfFFhFp")
        val expectedListWParts = listOf(
            listOf('v', 'J', 'r', 'w', 'p', 'W', 't', 'w', 'J', 'g', 'W', 'r', 'h', 'c', 's', 'F', 'M', 'M', 'f', 'F', 'F', 'h', 'F', 'p'),)

        val actualListWParts = extractParts(listWData)
        assertEquals(expectedListWParts, actualListWParts)
    }

    @Test
    fun testFindCommonChars(){
        val listWParts = listOf(
            listOf('v', 'J', 'r', 'w', 'p', 'W', 't', 'w', 'J', 'g', 'W', 'r', 'h', 'c', 's', 'F', 'M', 'M', 'f', 'F', 'F', 'h', 'F', 'p'),
            listOf('j', 'q', 'H', 'R', 'N', 'q', 'R', 'j', 'q', 'z', 'j', 'G', 'D', 'L', 'G', 'L', 'r', 's', 'F', 'M', 'f', 'F', 'Z', 'S', 'r', 'L', 'r', 'F', 'Z', 's', 'S', 'L'),
            listOf('P', 'm', 'm', 'd', 'z', 'q', 'P', 'r', 'V', 'v', 'P', 'w', 'w', 'T', 'W', 'B', 'w', 'g')
        )

        val expectedListWithChars = listOf('p', 'L', 'P')

        val actualListWithChars = findCommonChars(listWParts)

        assertEquals(expectedListWithChars, actualListWithChars)
    }

    @Test
    fun testCountPrio(){
        val listWithChars = listOf('p', 'L', 'P')
        val expectedSum = 96

        val actualSum = countPriority(listWithChars)

        assertEquals(expectedSum, actualSum)
    }

    }