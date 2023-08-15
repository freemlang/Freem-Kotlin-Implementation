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



    }
}

