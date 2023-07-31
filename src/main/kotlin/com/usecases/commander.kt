package com.usecases

import com.marsrover.MarsRover
import com.marsrover.Position

// class for commands check
class commander(val rover: MarsRover) {
    companion object {
        fun checkInputCommands(commandInput: String): Boolean {
            val regex = Regex("[MRL]+")
            return commandInput.matches(regex) && commandInput.isNotEmpty()
        }

        fun commandslist(rover: MarsRover, commandInput: String): Boolean {
            if (!checkInputCommands(commandInput)) {
                return false
            }
            for (command in commandInput) {
                when (command) {
                    'M' -> rover.move()
                    'L' -> rover.left()
                    'R' -> rover.right()
                }
            }
            return true
        }
    }
}