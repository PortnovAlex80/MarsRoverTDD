package com.usecases

import com.marsrover.Direction
import com.marsrover.MarsRover
import com.marsrover.Position
import com.plague.Plague
import com.plague.Size
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class commanderTest {
@Test
fun `Marsrover command input is not empty`() {
val commandInput : String   = "LMLMLMLMM"
    InstructionsProcessor.checkInputCommands(commandInput)
    assertTrue(InstructionsProcessor.checkInputCommands(commandInput))

}

    @Test
    fun `Marsrover command input is empty`() {
        val commandInput : String   = ""
        assertFalse(InstructionsProcessor.checkInputCommands(commandInput))

    }

    @Test
    fun `Marsrover command input is correct - contained only M char without spaces`() {
        val commandInput : String   = "M"
        assertTrue(InstructionsProcessor.checkInputCommands(commandInput))
    }

    @Test
    fun `Marsrover command input is correct - contained only R chars without spaces`() {
        val commandInput : String   = "R"
        assertTrue(InstructionsProcessor.checkInputCommands(commandInput))
    }

    @Test
    fun `Marsrover command input is correct - contained only L chars without spaces`() {
        val commandInput : String   = "L"
        assertTrue(InstructionsProcessor.checkInputCommands(commandInput))
    }

    @Test
    fun `Marsrover command input is NOT correct - contained any chars`() {
        val commandInput : String   = "L K.R"
        assertFalse(InstructionsProcessor.checkInputCommands(commandInput))
    }

    @Test
    fun `Marsrover command interface to move one step is OK`() {
        val commandInput : String   = "M"
        val position = Position(0,1)
        val rover = MarsRover();
        val plague = Plague(Size(5,5))
        InstructionsProcessor.commandslist(rover, commandInput, plague)
        assertEquals(position, rover.position)
    }

    @Test
    fun `Marsrover command interface to turn one step left is OK`() {
        val commandInput : String   = "L"
        val direction = Direction.NORTH
        val newDirection = Direction.WEST
        val position = Position(0,0)
        val rover = MarsRover(position,direction);

        val plague = Plague(Size(5,5))
        InstructionsProcessor.commandslist(rover, commandInput, plague)

        assertEquals(newDirection, rover.direction)
    }

    @Test
    fun `Marsrover command interface to turn one step right is OK`() {
        val commandInput : String   = "R"
        val direction = Direction.NORTH
        val newDirection = Direction.EAST
        val position = Position(0,0)
        val rover = MarsRover(position,direction);

        val plague = Plague(Size(5,5))
        InstructionsProcessor.commandslist(rover, commandInput, plague)

        assertEquals(newDirection, rover.direction)
    }

    @Test
    fun `Marsrover command interface to turn four step right is OK`() {
        val commandInput : String   = "RRRR"
        val direction = Direction.NORTH
        val position = Position(0,0)
        val rover = MarsRover(position,direction);

        val plague = Plague(Size(5,5))
        InstructionsProcessor.commandslist(rover, commandInput, plague)

        assertEquals(direction, rover.direction)
    }

    @Test
    fun `Marsrover command interface to turn four step left is OK`() {
        val commandInput : String   = "LLLL"
        val direction = Direction.NORTH
        val position = Position(0,0)
        val rover = MarsRover(position,direction);

        val plague = Plague(Size(5,5))
        InstructionsProcessor.commandslist(rover, commandInput, plague)

        assertEquals(direction, rover.direction)
    }

    @Test
    fun `Marsrover command interface to move four step toward is OK`() {
        val commandInput : String   = "MMMM"
        val direction = Direction.NORTH
        val position = Position(0,0)
        val rover = MarsRover(position,direction);

        val plague = Plague(Size(5,5))
        InstructionsProcessor.commandslist(rover, commandInput, plague)

        assertEquals(Position(0,4), rover.position)
    }

    @Test
    fun `Mars-rover command interface to move complex route 1 is OK`() {

        //        `LMLMLMLMM` 👈 управление положением первого марсохода
        val commandInput : String   = "LMLMLMLMM"

        //        `1 2 N` 👈 текущее положение и направление камеры первого марсохода
        val direction = Direction.NORTH
        val position = Position(1,2)
        val rover = MarsRover(position,direction);

        val plague = Plague(Size(5,5))
        InstructionsProcessor.commandslist(rover, commandInput, plague)

        //        `1 3 N` 👈 конечное положение и направление камеры первого марсохода
        assertEquals(Position(1,3), rover.position)
    }

    @Test
    fun `Mars-rover command interface to move complex route 2 is OK`() {

//        `MMRMMRMRRM` 👈 управление положением второго марсохода
        val commandInput : String   = "MMRMMRMRRM"

//        `3 3 E` 👈 текущее положение и направление камеры второго марсохода
        val direction = Direction.EAST
        val position = Position(3,3)
        val rover = MarsRover(position,direction);

        val plague = Plague(Size(5,5))
        InstructionsProcessor.commandslist(rover, commandInput, plague)

//        `5 1 E` 👈 конечное положение и направление камеры второго марсохода
        assertEquals(Position(5,1), rover.position)
    }

    @Test
    fun `Mars-rover route is on plague`() {

//        `MMRMMRMRRM` 👈 управление положением второго марсохода
        val commandInput : String   = "MMRMMRMRRM"

//        `3 3 E` 👈 текущее положение и направление камеры второго марсохода
        val direction = Direction.EAST
        val position = Position(3,3)
        val rover = MarsRover(position,direction);
        val plague = Plague(Size(5,5))
        InstructionsProcessor.commandslist(rover, commandInput, plague)
//        `5 1 E` 👈 конечное положение и направление камеры второго марсохода

        assertEquals(Position(5,1), rover.position)
    }

    @Test
    fun `Mars-rover route is out of plague`() {

//        `MMRMMRMRRM` 👈 управление положением второго марсохода
        val commandInput : String   = "MMRMMRMRRM"

//        `3 3 E` 👈 текущее положение и направление камеры второго марсохода
        val direction = Direction.EAST
        val position = Position(3,3)
        val rover = MarsRover(position,direction);
        val plague = Plague(Size(4,5))
        InstructionsProcessor.commandslist(rover, commandInput, plague)
//        `5 1 E` 👈 конечное положение и направление камеры второго марсохода

        assertEquals(Position(4,1), rover.position)
    }

}



