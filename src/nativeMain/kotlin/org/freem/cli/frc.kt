package org.freem.cli

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import org.freem.Process
import org.freem.tools.deferBlock
import kotlin.time.TimeSource

fun frc() = deferBlock {
    val mark = TimeSource.Monotonic.markNow()
    defer {
        val elapsed = mark.elapsedNow()
        println("\nuptime: ${elapsed.inWholeSeconds}s ${elapsed.inWholeMilliseconds}ms ${elapsed.inWholeMicroseconds}μs")
    }
}

object CompileConfig {
    private val parser = ArgParser(Process.exeNameWithoutExtension)

    val compileConfigName: String = "frconfig.json"
    val outputDir by parser.option(
        type = ArgType.String,
        fullName = "output",
        shortName = "o",
        description = "output path"
    ).default("${Process.execPath}/bin")


    init {
        parser.parse(Process.args)

        //val fs = FileSystem.SYSTEM
        //val files = fs.listRecursively(if (fs.metadataOrNull(targetDirPath)?.isDirectory == true) targetDirPath else throw FileNotFoundException(""))
    }
}
