package com.input

import com.marsrover.Direction
import com.marsrover.Position
import com.plague.Size

class interfaceInput

fun readPlagueSizeInput(): Size {
    println("Enter верхний правый угол плато")
    println("example: `5 5` (format: 'x y'):")

    while (true) {
        val input = readLine()
        val defaultSize = Size(100, 100)

        try {
            val (x, y) = input?.trim()?.split(" ")?.map { it.toInt() } ?: listOf(100, 100)

            if (x < 5 || y < 5) {
                println("Invalid input format. Minimum size for 'x' and 'y' is 5.")
                continue
            }

            println("Entered the Plague size is ${Size(x, y)} ")
            return Size(x, y)
        } catch (e: Exception) {
            println("Invalid input format. Please enter valid integers for 'x' and 'y'.")
        }
    }
}


fun getRoverCount(): Int {
    while (true) {
        println("Enter the number of Mars Rovers:")
        val input = readLine()

        try {
            val count = input?.toInt()
            if (count != null && count >= 1) {
                return count
            } else {
                println("Invalid input. Please enter a valid integer count greater than or equal to 1.")
            }
        } catch (e: Exception) {
            println("Invalid input. Please enter a valid integer count greater than or equal to 1.")
        }
    }
}

fun readRoverInput(roverNumber: Int): RoverPosition {
    println("Enter the starting position and direction for Rover $roverNumber (format: 'x y D', where D can be N, E, S, or W):")

    while (true) {
        val input = readLine()?.trim()

        if (input == null || input.isBlank()) {
            println("Invalid input format. Please enter the correct format 'x y D', where D can be N, E, S, or W.")
            continue
        }

        val parts = input.split(" ")

        if (parts.size != 3) {
            println("Invalid input format. Please enter the correct format 'x y D', where D can be N, E, S, or W.")
            continue
        }

        val (x, y, d) = parts

        val normalizedDirection = when (d.toUpperCase()) {
            "N" -> "NORTH"
            "E" -> "EAST"
            "S" -> "SOUTH"
            "W" -> "WEST"
            else -> {
                println("Invalid direction. Please enter N, E, S, or W for the direction.")
                continue
            }
        }

        try {
            val direction = Direction.valueOf(normalizedDirection)
            return RoverPosition(Position(x.toInt(), y.toInt()), direction)
        } catch (e: IllegalArgumentException) {
            println("Invalid input format. Please enter valid integers for 'x' and 'y'.")
        }
    }
}


data class RoverPosition(val position: Position, val direction: Direction)