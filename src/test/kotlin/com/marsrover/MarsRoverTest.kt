package com.marsrover

import com.marsrover.Direction
import com.marsrover.MarsRover
import com.marsrover.Position
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.assertEquals

class MarsRoverTest {
    @Test
    fun `Start position 0,0 must be 0,0`() {
        println("[TEST] Start position checking")
     val startPosition: Position = Position(0,0)
        println("Start position is " + startPosition)
        val rover = MarsRover()
        println("MarsRover position is "+rover.position)
        assertEquals(startPosition, rover.position)
    }
    @Test
    fun `Start direction N must be N (Nord)`() {
        println("[TEST] Start direcction checking")
        val startDirection: Direction = Direction.NORTH
        println("Start position is " + startDirection)
        val rover = MarsRover()
        println("MarsRover direction is "+rover.direction)
        assertEquals(startDirection, rover.direction)
    }

    @Test
    fun `Check any position and direction`() {
        println("[TEST] Start check any position and direction")
        val startDirection: Direction = Direction.values().random()
        val startPosition: Position = Position(Random.nextInt(0,101),Random.nextInt(0,101))

        println("Start position and direction is $startPosition and $startDirection")
        val rover = MarsRover(startPosition, startDirection)
        //val rover = MarsRover()
        println("MarsRover position and direction is $rover.position and $rover.direction")
        assertEquals(startDirection, rover.direction)
        assertEquals(startPosition, rover.position)
    }

    @Test
    fun `Check command go forward M(move) to NORTH`() {
        println("[TEST] Check command go forward M(move)")
        val startDirection: Direction = Direction.NORTH
        val startPosition: Position = Position(Random.nextInt(0,101),Random.nextInt(0,101))

        println("Start position and direction is $startPosition and $startDirection")
        val rover = MarsRover(startPosition, startDirection)
        rover.move()
        println("MarsRover position and direction is $rover.position and $rover.direction")
        assertEquals(Position( startPosition.x, startPosition.y + 1), rover.position)
    }

    @Test
    fun `Check command go forward M(move) to SOUTH`() {
        println("[TEST] Check command go forward M(move)")
        val startDirection: Direction = Direction.SOUTH
        val startPosition: Position = Position(Random.nextInt(0,101),Random.nextInt(0,101))

        println("Start position and direction is $startPosition and $startDirection")
        val rover = MarsRover(startPosition, startDirection)
        rover.move()
        println("MarsRover position and direction is $rover.position and $rover.direction")
        assertEquals(Position( startPosition.x, startPosition.y - 1), rover.position)
    }

    @Test
    fun `Check command go forward M(move) to EAST`() {
        println("[TEST] Check command go forward M(move)")
        val startDirection: Direction = Direction.EAST
        val startPosition: Position = Position(Random.nextInt(0,101),Random.nextInt(0,101))

        println("Start position and direction is $startPosition and $startDirection")
        val rover = MarsRover(startPosition, startDirection)
        rover.move()
        println("MarsRover position and direction is $rover.position and $rover.direction")
        assertEquals(Position( startPosition.x + 1, startPosition.y), rover.position)
    }

    @Test
    fun `Check command go forward M(move) to WEST`() {
        println("[TEST] Check command go forward M(move)")
        val startDirection: Direction = Direction.WEST
        val startPosition: Position = Position(Random.nextInt(0,101),Random.nextInt(0,101))

        println("Start position and direction is $startPosition and $startDirection")
        val rover = MarsRover(startPosition, startDirection)
        rover.move()
        println("MarsRover position and direction is $rover.position and $rover.direction")
        assertEquals(Position( startPosition.x - 1, startPosition.y), rover.position)
    }

    @Test
    fun `Check command 'L' turn ot the  Left)`() {
        println("[TEST] Check command 'L' turn ot the Left")
        val startDirection: Direction = Direction.WEST
        val startPosition: Position = Position(Random.nextInt(0,101),Random.nextInt(0,101))

        println("Start position and direction is $startPosition and $startDirection")
        val rover = MarsRover(startPosition, startDirection)
        rover.left()
        println("MarsRover position and direction is $rover.position and $rover.direction")
        assertEquals(Direction.SOUTH, rover.direction)
    }

    @Test
    fun `Check command 'R' turn ot the  Right)`() {
        println("[TEST] Check command 'R' turn ot the Right")
        val startDirection: Direction = Direction.WEST
        val startPosition: Position = Position(Random.nextInt(0,101),Random.nextInt(0,101))

        println("Start position and direction is $startPosition and $startDirection")
        val rover = MarsRover(startPosition, startDirection)
        rover.right()
        println("MarsRover position and direction is $rover.position and $rover.direction")
        assertEquals(Direction.NORTH, rover.direction)
    }

}


