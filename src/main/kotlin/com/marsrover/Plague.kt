package com.marsrover

class Plague(val size: Size) {
    fun isWithinSize(position: Position): Boolean {
        return position.x in 0..size.x && position.y in 0..size.y
    }
}

data class Size (val  x: Int, val y: Int)