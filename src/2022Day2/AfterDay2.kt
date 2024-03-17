import java.io.File

//https://www.reddit.com/r/adventofcode/comments/zac2v2/comment/iyocqtr/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button
fun main() {

    val rounds = File("src/2022Day2/20221202.txt").readLines().map { it[0] to it[2] }

    //Kör play som har logiken och poängen och summerar den här(it[0]/[2] = vilken char som är första och andra)
    println(rounds.sumOf { it.play() })
    //Del 2
    println(rounds.sumOf { it.playSecond() })


}
//this är nuvarande instans av par tex(A X)
fun Pair<Char, Char>.play() = when (this) {
    //Får in ett par och hittar matching till paret

    //Förlorar, tex A Z (Rock mot scissor) 0 poäng
    'A' to 'Z', 'B' to 'X', 'C' to 'Y' -> 0
    //Lika
    'A' to 'X', 'B' to 'Y', 'C' to 'Z' -> 3
    //Om ingen match på ovanstående så har vi vunnit
    else -> 6


    //En andra when sats där vi tilldelar poängen beroende vilken andra char'en är(this.second)
} + when (this.second) {

    'Z' -> 3
    'Y' -> 2
    else -> 1
}

//Del 2


fun Pair<Char, Char>.playSecond() = when (this) {
//Ger char poängen här, smart sätt då den ger poängen utan att behöva göra om de till rätt char, som jag gjorde i min before
    //Om det är X ska vi förlora, Y ska bli lika, Z ska vi vinna
    //T ex. 'A' to 'Y', då gör vi om Y till X för att det ska bli lika(rock mot rock) Y ger 1 poäng
    'A' to 'Y', 'B' to 'X', 'C' to 'Z' -> 1
    'A' to 'Z', 'B' to 'Y', 'C' to 'X' -> 2
    else -> 3
} + when (this.second) {
    //Z Vinner
    'Z' -> 6
    //Y Lika
    'Y' -> 3
    //X Förlorar
    else -> 0
}