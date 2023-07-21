package org.freem.project.manager

import kotlinx.cinterop.*
import kotlinx.cli.ExperimentalCli
import kotlinx.cli.Subcommand
import platform.windows.*

@OptIn(ExperimentalCli::class, ExperimentalForeignApi::class)
object InitCommand: Subcommand(name = "init", actionDescription = "Initialize project") {

    override fun execute() {
        println("start")

        memScoped {
            val inputHandle = GetStdHandle(STD_INPUT_HANDLE)
            val consoleMode = alloc<DWORDVar>()
            GetConsoleMode(inputHandle, consoleMode.ptr)
            SetConsoleMode(inputHandle, consoleMode.value or ENABLE_EXTENDED_FLAGS.toUInt()/* or operate to active bit */)
            try {
                val bufferSize = 128
                val inputBuffer = allocArray<INPUT_RECORD>(bufferSize)

                println("Waiting for key input... (press 'q' to exit)")
                while (true) {
                    val numEvents = alloc<DWORDVar>()
                    ReadConsoleInput!!(inputHandle, inputBuffer, bufferSize.toUInt(), numEvents.ptr)

                    for (i in 0..<numEvents.value.toInt()) {
                        val eventType = inputBuffer[i].EventType
                        if (eventType.toInt() == KEY_EVENT) {
                            val keyEvent = inputBuffer[i].Event.KeyEvent
                            if (keyEvent.bKeyDown == TRUE) {
                                val char = keyEvent.uChar.UnicodeChar.toInt().toChar()
                                println("key: $char")
                                if (char == 'q') return
                            }
                        }
                    }
                }
            } finally {
                SetConsoleMode(inputHandle, consoleMode.value)
            }
        }

        println("fin")
    }

    private fun getProperty(msg: String): String {
        print(msg)
        return readln()
    }
}

