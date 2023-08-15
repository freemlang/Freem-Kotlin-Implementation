package org.freem.cli

import kotlinx.cli.ArgParser
import kotlinx.cli.ExperimentalCli
import org.freem.Process
import org.freem.project.manager.InitCommand
import org.freem.project.manager.RunCommand
import org.freem.tools.scope.checkElapsed
import org.freem.tools.scope.deferBlock

@OptIn(ExperimentalCli::class)
fun fpm() = deferBlock {
    checkElapsed()

    val parser = ArgParser(Process.exeNameWithoutExtension)
    parser.subcommands(
        InitCommand,
        RunCommand,
    )
    parser.parse(Process.args)
}
