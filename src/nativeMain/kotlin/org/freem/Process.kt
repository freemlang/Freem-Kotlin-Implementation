package org.freem

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.get
import kotlinx.cinterop.toKString
import okio.FileSystem
import okio.Path.Companion.toPath
import platform.posix.__argc
import platform.posix.__argv

@OptIn(ExperimentalForeignApi::class)
object Process {
    val argv: Array<String> = arrayOf(
        __argv!![0]!!.toKString(),
        FileSystem.SYSTEM.canonicalize("./".toPath()).toString(),
        *Array(__argc - 1) { index -> __argv!![index + 1]!!.toKString() }
    )
    val args: Array<String> = argv.drop(2).toTypedArray()
    val argc: Int = __argc
    val argv0: String = argv[0]
    val argv1: String = argv[1]
    val exePath: String = argv0
    val exeDir: String = argv0.toPath().parent!!.toString()
    val exeName: String = argv0.toPath().name
    val exeNameWithoutExtension: String = exeName.substringBeforeLast('.')
    val execPath: String = argv1
}