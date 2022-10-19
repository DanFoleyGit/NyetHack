fun main() {
    narrate("A here enters the town of Krondstadt. What is their name?")
    val heroName = readLine() ?: ""

    changeNarratorMood()
    narrate("$heroName heads to the town square")
}