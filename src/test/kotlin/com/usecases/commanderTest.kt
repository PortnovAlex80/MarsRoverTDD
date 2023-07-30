package com.usecases

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.assertEquals
class commanderTest {
@Test
fun `Marsrover command input is not empty`() {
val commandInput : String   = "LMLMLMLMM"
    commander.commands(commandInput)
    assertTrue(commander.commands(commandInput))

}

    @Test
    fun `Marsrover command input is empty`() {
        val commandInput : String   = ""
        assertFalse(commander.commands(commandInput))

    }

    @Test
    fun `Marsrover command input is correct - contained only M char without spaces`() {
        val commandInput : String   = "M"
        assertTrue(commander.commands(commandInput))
    }

    @Test
    fun `Marsrover command input is correct - contained only R chars without spaces`() {
        val commandInput : String   = "R"
        assertTrue(commander.commands(commandInput))
    }

    @Test
    fun `Marsrover command input is correct - contained only L chars without spaces`() {
        val commandInput : String   = "L"
        assertTrue(commander.commands(commandInput))
    }

    @Test
    fun `Marsrover command input is NOT correct - contained any chars`() {
        val commandInput : String   = "L K.R"
        assertFalse(commander.commands(commandInput))
    }
}