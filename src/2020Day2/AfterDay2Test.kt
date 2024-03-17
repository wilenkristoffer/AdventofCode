package `2020Day2`

import junit.framework.TestCase.assertEquals
import org.junit.Test

class TestForAfterDay2{

@Test
fun testValidatePartOne() {
    val password1 = PasswordWithPolicy("abcde", 1..3, 'a')
    val password2 = PasswordWithPolicy("cdefg", 1..3, 'b')
    val password3 = PasswordWithPolicy("ccccccccc", 2..9, 'c')

    assertEquals(true, password1.validatePartOne())
    assertEquals(false, password2.validatePartOne())
    assertEquals(true, password3.validatePartOne())
}

@Test
fun testValidatePartTwo() {
    val password1 = PasswordWithPolicy("abcde", 1..3, 'a')
    val password2 = PasswordWithPolicy("cdefg", 1..3, 'b')
    val password3 = PasswordWithPolicy("ccccccccc", 2..9, 'c')

    assertEquals(true, password1.validatePartTwo())
    assertEquals(false, password2.validatePartTwo())
    assertEquals(false, password3.validatePartTwo())
}
}