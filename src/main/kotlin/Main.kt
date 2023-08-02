import com.marsrover.getRoverCount
import com.marsrover.getPlagueSize
import com.marsrover.getStartRoverPosition
import com.marsrover.Plague
import com.marsrover.MarsRover
import com.marsrover.RoverInstructionsProcessor

fun main(args: Array<String>) {

    val plague = Plague(getPlagueSize())

    val roverCount = getRoverCount()
    val rovers = mutableListOf<MarsRover>()

    for (i in 1..roverCount) {
        val roverPosition = getStartRoverPosition(i)
        val rover = MarsRover(roverPosition.position, roverPosition.direction)
        rovers.add(rover)
    }
    println("Rovers created")

    // Infinite game loop
    while (true) {
        for ((index, rover) in rovers.withIndex()) {
            println("Enter movement instructions for Rover ${index + 1} (or type 'exit' to quit the game):")
            val commands = readLine()?.toUpperCase()

            if (commands == "EXIT") {
                println("Exiting the game. Goodbye!")
                return
            } else if (commands != null && RoverInstructionsProcessor.isCommandsCorrect(commands)) {
                // Process the commands for the rover
                RoverInstructionsProcessor.executor(rover, commands, plague)

                println("Final position for Rover ${index + 1}: ${rover.position}, Direction: ${rover.direction}")
            } else {
                println("Invalid input. Please enter valid movement commands for Rover ${index + 1} (only 'M', 'R', or 'L').")
            }
        }
    }

}


