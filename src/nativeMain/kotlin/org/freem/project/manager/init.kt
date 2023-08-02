package org.freem.project.manager

import kotlinx.cinterop.*
import kotlinx.cinterop.internal.CCall
import kotlinx.cinterop.internal.ConstantValue
import kotlinx.cli.ExperimentalCli
import kotlinx.cli.Subcommand
import platform.posix.scanf
import platform.windows.*

@OptIn(ExperimentalCli::class, ExperimentalForeignApi::class)
object InitCommand: Subcommand(name = "init", actionDescription = "Initialize project") {
    override fun execute() {


        /*
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

            try {
                val bufferSize = 128
                val inputBuffer = allocArray<INPUT_RECORD>(bufferSize)

                val startPos = alloc<CONSOLE_SCREEN_BUFFER_INFO> { GetConsoleScreenBufferInfo(outputHandle, this.ptr) }.dwCursorPosition
                val currentPos = alloc<CONSOLE_SCREEN_BUFFER_INFO> { GetConsoleScreenBufferInfo(outputHandle, this.ptr) }.dwCursorPosition

                var loop = true

                val input = mutableListOf<CHAR>()

                var index = 0
                while (loop) {
                    val inputAmount = alloc<DWORDVar>()
                    ReadConsoleInputW(inputHandle, inputBuffer, bufferSize.toUInt(), inputAmount.ptr)
                    val keyEvents = Array(inputAmount.value.toInt()) { inputBuffer[it] }
                        .filter { it.EventType.toInt() == KEY_EVENT }
                        .map { it.Event.KeyEvent }

                    for (keyEvent in keyEvents) {
                        if (keyEvent.bKeyDown == TRUE) {
                            val char = keyEvent.uChar.UnicodeChar.toInt().toChar()
                            if (!char.isISOControl()) {
                                input.add(currentPos.X.toInt(), char)
                                currentPos.X = (currentPos.X + 1).toShort()
                            }
                            else when (keyEvent.wVirtualKeyCode.toInt()) {
                                VK_ESCAPE, VK_RETURN -> loop = false
                                VK_BACK -> {
                                    val index = currentPos.X - startPos.X - 1
                                    if (index >= 0) {
                                        input.removeAt(index)
                                        currentPos.X = (currentPos.X - 1).toShort()
                                    }
                                }
                                VK_DELETE -> {

                                }
                                VK_INSERT -> {}
                                VK_HOME -> {}
                                VK_END -> {}
                                VK_TAB -> {}
                                VK_UP -> {}
                                VK_DOWN -> {}
                                VK_LEFT -> if (currentPos.X - startPos.X > 0) currentPos.X = (currentPos.X - 1).toShort()
                                VK_RIGHT -> {
                                    if (currentPos.X - startPos.X < input.size) currentPos.X = (currentPos.X + 1).toShort()
                                }
                            }
                        }
                    }
                    SetConsoleCursorPosition(outputHandle, startPos.readValue())
                    print(input.joinToString(""))
                    print(" loop $index ")
                    index++
                    SetConsoleCursorPosition(outputHandle, currentPos.readValue())
                }
            } finally {
                SetConsoleMode(inputHandle, consoleMode.value)
            }
        }
         */
    }
}

