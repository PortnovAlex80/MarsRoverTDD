package com.marsrover

class MarsRover(var  position: Position = Position (0,0),
                val direction: Direction = Direction.NORTH) {

    fun move() {
        position = when (direction) {
            Direction.NORTH -> Position(position.x, position.y + 1)
            Direction.SOUTH -> Position(position.y, position.y - 1)
            Direction.EAST -> Position(position.x + 1, position.y)
            Direction.WEST -> Position(position.x - 1, position.y)
        }
    }
}

data class Position (val  x: Int, val y: Int)

enum class Direction(val symbol: Char) {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W')
}
