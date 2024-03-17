package `2022Day2`


import junit.framework.TestCase.assertEquals
import org.junit.Test


class testForBeforeDay2{

    @Test
    fun testCalculateOutcome(){
        val parEtt = listOf('A', 'Y')//Rock mot paper
        val expectedResEtt = 'W'
        val parTvå = listOf('B', 'X')//Paper mot rock
        val expectedResTvå = 'L'

        val resultatEtt = calculateOutcome(parEtt[0], parEtt[1])
        assertEquals(expectedResEtt, resultatEtt)
        val resutaltTvå = calculateOutcome(parTvå[0], parTvå[1])
        assertEquals(expectedResTvå, resutaltTvå)

    }

    @Test
    fun testCalculateScore(){
        val responseMoveEtt = 'Y'
        val outcomeEtt = 'W'

        val expectedResEtt = 8

        val resultatEtt = calculateScore(responseMoveEtt, outcomeEtt)

        assertEquals(expectedResEtt, resultatEtt)


        val responseMoveTvå = 'X'
        val outcomeTvå = 'L'

        val expectedResTvå = 1

        val resultatTvå = calculateScore(responseMoveTvå, outcomeTvå)

        assertEquals(expectedResTvå, resultatTvå)

    }
}