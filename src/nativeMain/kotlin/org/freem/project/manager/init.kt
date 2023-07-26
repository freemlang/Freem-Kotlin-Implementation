package org.freem.project.manager

import kotlinx.cinterop.*
import kotlinx.cli.ExperimentalCli
import kotlinx.cli.Subcommand
import platform.posix.printf
import platform.posix.scanf
import platform.posix.stdout
import platform.windows.*
import kotlin.native.internal.isPermanent

@OptIn(ExperimentalCli::class, ExperimentalForeignApi::class)
object InitCommand: Subcommand(name = "init", actionDescription = "Initialize project") {
    override fun execute() {
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

                    for (keyEvent in keyEvents) {
                        if (keyEvent.bKeyDown == TRUE) {
                            val char = keyEvent.uChar.UnicodeChar.toInt().toChar()
                            if (char.isISOControl()) input.append(char)
                            else when (keyEvent.wVirtualKeyCode.toInt()) {
                                VK_ESCAPE, VK_RETURN -> break
                                VK_BACK -> {
                                    val dwCurrPos = alloc<CONSOLE_SCREEN_BUFFER_INFO>
                                    { GetConsoleScreenBufferInfo(outputHandle, this.ptr) }.dwCursorPosition

                                }
                                VK_DELETE -> {}
                                VK_INSERT -> {}
                                VK_HOME -> {}
                                VK_END -> {}
                                VK_TAB -> {}
                                VK_UP -> {}
                                VK_DOWN -> {}
                                VK_LEFT -> {}
                                VK_RIGHT -> {}
                            }
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

