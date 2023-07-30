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

}