package org.freem.compiler

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.get
import kotlinx.cinterop.toKString
import platform.posix.__argc
import platform.posix.__argv

@OptIn(ExperimentalForeignApi::class)
object Process {
    val argc: Int get() = argv.size
    val argv: Array<String> = Array(__argc) { index -> __argv!![index]!!.toKString() }
    val argv0: String = argv[0]
    val args: Array<String> = argv.drop(1).toTypedArray()
    val execPath: String = argv0
    val execDir: String = argv0.substringBeforeLast('\\')
    val execName: String = argv0.substringAfterLast('\\')
}