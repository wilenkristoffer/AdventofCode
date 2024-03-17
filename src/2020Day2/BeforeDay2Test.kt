package `2020Day2`

import junit.framework.TestCase.assertEquals
import org.junit.Test

class TestForBeforeDay2{

    @Test
    fun testLösnordValid() {
        val policy = PasswordPolicy(2, 9, 'c', "ccccccccc")
        val isValid = isPasswordValid(policy, "ccccccccc")
        assertEquals(true, isValid)
    }

    @Test
    fun testLösenordInvalid() {
        val policy = PasswordPolicy(1, 3, 'b', "cdefg")
        val isValid = isPasswordValid(policy, "cdefg")
        assertEquals(false, isValid)
    }

}