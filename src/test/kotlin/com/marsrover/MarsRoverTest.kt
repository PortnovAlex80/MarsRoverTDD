package com.marsrover

import org.junit.jupiter.api.Test
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
}

