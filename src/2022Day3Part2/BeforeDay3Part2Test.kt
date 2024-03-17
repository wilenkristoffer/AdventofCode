package `2022Day3Part2`

import junit.framework.TestCase.assertEquals
import org.junit.Test

class testForBeforeDay3Part2{

    @Test
    fun testExtractThree(){
        val listWData = listOf("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg")
        val expectedListWParts = listOf(
            listOf(
            listOf('v', 'J', 'r', 'w', 'p', 'W', 't', 'w', 'J', 'g', 'W', 'r', 'h', 'c', 's', 'F', 'M', 'M', 'f', 'F', 'F', 'h', 'F', 'p'),
            listOf('j', 'q', 'H', 'R', 'N', 'q', 'R', 'j', 'q', 'z', 'j', 'G', 'D', 'L', 'G', 'L', 'r', 's', 'F', 'M', 'f', 'F', 'Z', 'S', 'r', 'L', 'r', 'F', 'Z', 's', 'S', 'L'),
            listOf('P', 'm', 'm', 'd', 'z', 'q', 'P', 'r', 'V', 'v', 'P', 'w', 'w', 'T', 'W', 'B', 'w', 'g')
        ))

        val actualListWParts = extractThreeParts(listWData)

        assertEquals(expectedListWParts, actualListWParts)
    }

    @Test
    fun testFindCommonChar(){
        val listWParts = listOf(
            listOf(
                listOf('v', 'J', 'r', 'w', 'p', 'W', 't', 'w', 'J', 'g', 'W', 'r', 'h', 'c', 's', 'F', 'M', 'M', 'f', 'F', 'F', 'h', 'F', 'p'),
                listOf('j', 'q', 'H', 'R', 'N', 'q', 'R', 'j', 'q', 'z', 'j', 'G', 'D', 'L', 'G', 'L', 'r', 's', 'F', 'M', 'f', 'F', 'Z', 'S', 'r', 'L', 'r', 'F', 'Z', 's', 'S', 'L'),
                listOf('P', 'm', 'm', 'd', 'z', 'q', 'P', 'r', 'V', 'v', 'P', 'w', 'w', 'T', 'W', 'B', 'w', 'g')
            ))

        val expectedListWChars = listOf('r')

        val actualListWChars = findCommonChar(listWParts)

        assertEquals(expectedListWChars, actualListWChars)
    }

    @Test
    fun testCountPrio(){

        val listWithChars = listOf('r', 'Z', 'd')
        val expectedSum = 74

        val actualSum = countPriority(listWithChars)

        assertEquals(expectedSum, actualSum)
    }

}