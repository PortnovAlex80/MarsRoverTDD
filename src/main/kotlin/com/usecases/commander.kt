package com.usecases

// class for commands check
class commander {
    companion object {
        fun commands(commandInput: String): Boolean {
            return commandInput.isNotEmpty()

        }
    }
}