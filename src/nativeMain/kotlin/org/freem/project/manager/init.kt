package org.freem.project.manager

import kotlinx.cinterop.*
import kotlinx.cli.ExperimentalCli
import kotlinx.cli.Subcommand
import platform.posix.printf
import platform.posix.scanf
import platform.posix.stdout
import platform.windows.*

@OptIn(ExperimentalCli::class, ExperimentalForeignApi::class)
object InitCommand: Subcommand(name = "init", actionDescription = "Initialize project") {
    override fun execute() {

        print("yeongjae babo: ")

        memScoped {
            fun getStdHandle(nStdHandle: DWORD): HANDLE {
                val handle = GetStdHandle(nStdHandle)
                if (handle == INVALID_HANDLE_VALUE || handle == null)
                    throw Exception("std handle not found")
                return handle
            }
            val inputHandle: HANDLE = getStdHandle(STD_INPUT_HANDLE)
            val outputHandle: HANDLE = getStdHandle(STD_OUTPUT_HANDLE)

            val consoleMode = alloc<DWORDVar>()
            GetConsoleMode(inputHandle, consoleMode.ptr)
            val consoleFlags = arrayOf<Int>(
                //ENABLE_EXTENDED_FLAGS,
                ENABLE_ECHO_INPUT,
                ENABLE_LINE_INPUT,
                ENABLE_QUICK_EDIT_MODE,
                //ENABLE_VIRTUAL_TERMINAL_PROCESSING,
            )
            SetConsoleMode(inputHandle, consoleFlags.fold(0u) { result, flag -> result or flag.toUInt() })

            val input = StringBuilder()

            try {
                val bufferSize = 128
                val inputBuffer = allocArray<INPUT_RECORD>(bufferSize)
                while (true) {
                    val numEvents = alloc<DWORDVar>()
                    ReadConsoleInputW(inputHandle, inputBuffer, bufferSize.toUInt(), numEvents.ptr)
                    val keyEvents = Array(numEvents.value.toInt()) { inputBuffer[it] }
                        .filter { it.EventType.toInt() == KEY_EVENT }
                        .map { it.Event.KeyEvent }

                    keyEvents.forEach { keyEvent ->
                        if (keyEvent.bKeyDown == TRUE) {
                            when (keyEvent.wVirtualKeyCode.toInt()) {
                                VK_ESCAPE -> return
                                VK_BACK -> {
                                    val dwCurrPos = alloc<CONSOLE_SCREEN_BUFFER_INFO>
                                    { GetConsoleScreenBufferInfo(outputHandle, this.ptr) }.dwCursorPosition

                                }
                                VK_DELETE -> {

                                }
                                VK_RETURN -> {
                                    return@memScoped
                                }
                            }

                            val charCode = keyEvent.uChar.UnicodeChar.toInt()
                            val char = charCode.toChar()
                            input.append(char)
                        }
                    }

                    val pos = alloc<COORD> {
                        val dwCurrPos = alloc<CONSOLE_SCREEN_BUFFER_INFO>
                        { GetConsoleScreenBufferInfo(outputHandle, this.ptr) }.dwCursorPosition

                        X = dwCurrPos.X
                        Y = dwCurrPos.Y
                    }
                    SetConsoleCursorPosition(outputHandle, pos.readValue())
                }
            } finally {
                SetConsoleMode(inputHandle, consoleMode.value)
            }
        }
    }
}

