package `2022Day2`

import junit.framework.TestCase.assertEquals
import org.junit.Test
import play
import playSecond

class testForAfterDay2{


    @Test
    fun testForPlay(){

        val rundor = listOf(
            'C' to 'Y', //Förlorar 0 + (2 för "Y") = 2
            'C' to 'Z', //Lika 3 + (3 för "Z") = 6
            'A' to 'Y' //Vinner 6 + (2 för "Y") = 8
        )

        val expectedResults = listOf(2, 6, 8)

        val actualResults = rundor.map { it.play() }

        assertEquals(expectedResults, actualResults)
    }

    @Test
    fun testForPlaySecond(){

        val rundor = listOf(
            'A' to 'Y', //Y det måste bli lika, görs om till X, 3 + (1 för "X") = 4
            'B' to 'X', //X vi måste förlora, görs om till X, 0 + (1 för "X") = 1
            'C' to 'Z' //Z vi måste vinna, görs om till X, 6 + (1 för "X") = 7
        )

        val expectedResults = listOf(4, 1, 7)

        val actualResults = rundor.map { it.playSecond() }

        assertEquals(expectedResults, actualResults)
    }
}