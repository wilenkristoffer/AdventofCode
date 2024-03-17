import Tomteland.Tomteland
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

    class TomtelandTest {

        private val tomteland = Tomteland()

        init {
            tomteland.addPerson("Tomten", listOf("Glader", "Butter"))
            tomteland.addPerson("Glader", listOf("Tröger", "Trötter", "Blyger"))
            tomteland.addPerson("Butter", listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"))
            tomteland.addPerson("Trötter", listOf("Skumtomten"))
            tomteland.addPerson("Räven", listOf("Gråsuggan", "Myran"))
            tomteland.addPerson("Skumtomten", listOf("Dammråttan"))
            tomteland.addPerson("Myran", listOf("Bladlusen"))
        }

        @Test
        fun testUnderlingsTomten() {
            val underlings = tomteland.underlings("Tomten")
            assertEquals(14, underlings.size)
        }

        @Test
        fun testUnderlingsGlader() {
            val underlings = tomteland.underlings("Glader")
            assertEquals(5, underlings.size)
        }

        @Test
        fun testUnderlingsButter() {
            val underlings = tomteland.underlings("Butter")
            assertEquals(7, underlings.size)
        }

        @Test
        fun testUnderlingsTrötter() {
            val underlings = tomteland.underlings("Trötter")
            assertEquals(2, underlings.size)
        }

        @Test
        fun testUnderlingsRäven() {
            val underlings = tomteland.underlings("Räven")
            assertEquals(3, underlings.size)
        }

        @Test
        fun testUnderlingsSkumtomten() {
            val underlings = tomteland.underlings("Skumtomten")
            assertEquals(1, underlings.size)
        }

        @Test
        fun testUnderlingsMyran() {
            val underlings = tomteland.underlings("Myran")
            assertEquals(1, underlings.size)
        }

        @Test
        fun testUnderlingsBladlusen() {
            val underlings = tomteland.underlings("Bladlusen")
            assertEquals(0, underlings.size)
        }
    }

