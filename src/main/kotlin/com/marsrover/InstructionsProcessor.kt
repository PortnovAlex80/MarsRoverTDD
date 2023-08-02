package com.marsrover

// class for commands check
class InstructionsProcessor(val rover: MarsRover, var plague: Plague) {

    companion object {
        fun checkInputCommands(commandInput: String): Boolean {
            val regex = Regex("[MRL]+")
            return commandInput.matches(regex) && commandInput.isNotEmpty()
        }

        fun commandslist(rover: MarsRover, commandInput: String, plague: Plague): Boolean {
            if (!checkInputCommands(commandInput)) {
                return false
            }
            for (command in commandInput) {
                // Calculate the next position without actually moving the rover
                val nextPosition = when (command) {
                    'M' -> when (rover.direction) {
                        Direction.NORTH -> rover.position.copy(y = rover.position.y + 1)
                        Direction.SOUTH -> rover.position.copy(y = rover.position.y - 1)
                        Direction.EAST -> rover.position.copy(x = rover.position.x + 1)
                        Direction.WEST -> rover.position.copy(x = rover.position.x - 1)
                    }
                    else -> rover.position // For 'L' and 'R', there is no change in position
                }
                // Check if the next position is within the plateau's size
                if (plague.isWithinSize(nextPosition)) {
                    // Execute the command only if the next position is within the size
                    when (command) {
                        'M' -> rover.move()
                        'L' -> rover.left()
                        'R' -> rover.right()
                    }
                }
            }
            return true
        }
    }
}
