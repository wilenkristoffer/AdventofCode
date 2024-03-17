package `2020Day2Part2`

import junit.framework.TestCase
import org.junit.Test

class TestForBeforeDay2Part2{

    @Test
    fun testLösnordValid() {
        val policy = PasswordPolicy(1, 3, 'a', "abcde")
        val isValid = isPasswordValid(policy, "abcde")
        TestCase.assertEquals(true, isValid)
    }

    @Test
    fun testLösenordInvalid() {
        val policy = PasswordPolicy(1, 3, 'b', "cdefg")
        val isValid = isPasswordValid(policy, "cdefg")
        TestCase.assertEquals(false, isValid)
    }

}