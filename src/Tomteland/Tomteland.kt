package Tomteland

import javax.swing.JComboBox
import javax.swing.JOptionPane
import javax.swing.JPanel

class Tomteland {

    //tomteMap för att hantera data-strukturen. Nyckel är tomtenamnet, värdet är en mutable lista med underordnade
    private val tomteMap = mutableMapOf<String, MutableList<String>>()

    //En funktion för lägga till tomtenamnet med en lista av underordnade
    fun addPerson(name: String, underlings: List<String>) {
        tomteMap[name] = underlings.toMutableList()
    }
    fun underlings(currentName: String, res: MutableList<String> = mutableListOf()): List<String> {
        //Hämtar listan med underordnade som är associerat med tomtenamnet och lägger till i res listan,
        // res blir en tom lista ifall det inte finns några underordnade kopplat till tomtenamnet
        res.addAll(tomteMap[currentName] ?: emptyList())
        //forEach går igenom varje underordnade i listan
        // sedan kallar vi på underlings för att lägga till underordnade i listan(rekursion) tills det inte finns någon kvar
        tomteMap[currentName]?.forEach { underling ->
            underlings(underling, res)
        }
        return res
    }
}

fun main() {
    val tomteland = Tomteland()


    tomteland.addPerson("Tomten", listOf("Glader", "Butter"))
    tomteland.addPerson("Glader", listOf("Tröger", "Trötter", "Blyger"))
    tomteland.addPerson("Butter", listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"))
    tomteland.addPerson("Trötter", listOf("Skumtomten"))
    tomteland.addPerson("Räven", listOf("Gråsuggan", "Myran"))
    tomteland.addPerson("Skumtomten", listOf("Dammråttan"))
    tomteland.addPerson("Myran", listOf("Bladlusen"))

    //Kod för att få ett litet gränssnitt där man kan välja tomte, om vi väljer bladlusen får vi ut en tom lista(för demonstration)
    val names = arrayOf("Tomten", "Glader", "Butter", "Trötter", "Räven", "Skumtomten", "Myran", "Bladlusen")

    val panel = JPanel()
    val comboBox = JComboBox(names)
    panel.add(comboBox)

    val result = JOptionPane.showConfirmDialog(
        null, panel,"Välj en tomte",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE
    )

    if (result == JOptionPane.OK_OPTION) {
        val selectedName = comboBox.selectedItem as String
        //kallar på underlings funktionen som tar in namnet vi valt och en initialt tom mutable lista
        val underlings = tomteland.underlings(selectedName, mutableListOf())
        println("$underlings")
        println(underlings.size)
    }

}
