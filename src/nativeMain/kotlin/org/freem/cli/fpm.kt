package org.freem.cli

import kotlinx.cli.ArgParser
import kotlinx.cli.ExperimentalCli
import org.freem.Process
import org.freem.compiler.util.deferBlock
import org.freem.project.manager.InitCommand
import org.freem.project.manager.RunCommand
import kotlin.time.TimeSource

@OptIn(ExperimentalCli::class)
fun fpm() = deferBlock {
    val mark = TimeSource.Monotonic.markNow()
    defer {
        val elapsed = mark.elapsedNow()
        println("\nuptime: ${elapsed.inWholeMilliseconds}ms(${elapsed.inWholeMicroseconds}μs)")
    }

    val parser = ArgParser(Process.exeNameWithoutExtension)
    parser.subcommands(
        InitCommand,
        RunCommand,
    )
    parser.parse(Process.args)
}
