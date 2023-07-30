package com.marsrover

class MarsRover(var  position: Position = Position (0,0),
                var direction: Direction = Direction.NORTH) {

    fun move() {
        position = when (direction) {
            Direction.NORTH -> Position(position.x, position.y + 1)
            Direction.SOUTH -> Position(position.x, position.y - 1)
            Direction.EAST -> Position(position.x + 1, position.y)
            Direction.WEST -> Position(position.x - 1, position.y)
        }
    }

    fun left() {
        direction = direction.left()
    }
}

data class Position (val  x: Int, val y: Int)

enum class Direction(val symbol: Char) {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    companion object {
        val count = values().size
    }

    // Helper function to calculate the next direction when turning left
    fun left(): Direction {
        val newIndex = (ordinal - 1 + count) % count
        return values()[newIndex]
    }
}
