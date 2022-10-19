import kotlin.random.Random
import kotlin.random.nextInt

var narrationModifier: (String) -> String = { it }

fun narrate(
    message: String
) {
    println(narrationModifier(message)) // Extra parenthesis calls the lambda functions above
}

fun changeNarratorMood() {
    val mood: String
    val modifier: (String) -> String

    when (Random.nextInt(1..4)){
        1 -> {
            mood = "loud"
            modifier = { message: String -> // can also name parameter like "message ->" rather than it
                val numExclamationPoints = 3
                message.uppercase() + "!".repeat(numExclamationPoints)
            }
        }
        2 -> {
            mood = "tired"
            modifier = { message: String -> // can also name parameter like "message ->" rather than it
                message.lowercase().replace(" ","...")
            }
        }
        3 -> {
            mood = "unsure"
            modifier = { message ->
                "$message?"
            }
        }
        else -> {
            mood = "professional"
            modifier = {message ->
                "$message."
            }
        }
    }
    narrationModifier = modifier
    narrate("The narrator begins to feel $mood")
}

// Lambda functions Implicitly return the last line of the function so no need for the return keyword

// can use it keyword instead of parameter name if only one parameter is passed

// REPL Example of two parameters
/*
val loudNarration: (String, String) -> String = { message, tone ->
    when (tone) {
        "excited" -> {
            val numExclamationPoints = 3
            message.uppercase() + "!".repeat(numExclamationPoints)
        }
        "sneaky" -> {
            "$message. The narrator has just blown the madrigals cover".uppercase()
        }
        else -> message.uppercase()
    }
}
println(loudNarration("Madrigal cautisouly tip toes through the hallway", "sneaky"))
 */

// Lambda example
/*
val narrationModifier = { message: String -> // can also name parameter like "message ->" rather than it
    val numExclamationPoints = 3
    message.uppercase() + "!".repeat(numExclamationPoints)
}
println(narrationModifier(message)) // Extra parenthesis calls the lambda functions above

 */