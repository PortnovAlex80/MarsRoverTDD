package com.usecases

// class for commands check
class commander {
    companion object {
        fun commands(commandInput: String): Boolean {
            val regex = Regex("[MRL]+")
            return commandInput.matches(regex) && commandInput.isNotEmpty()
        }
    }
}