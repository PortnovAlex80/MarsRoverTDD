package com.plague

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlagueTest {

    @Test
    fun `Platue size is correct` (){
        val plague = Plague(Size(5,5))
        val size = Size(5,5)
        assertEquals(plague.size, size)
    }
}

