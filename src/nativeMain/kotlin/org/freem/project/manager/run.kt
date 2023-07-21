package org.freem.project.manager

import kotlinx.cli.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.*
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.buffer
import org.freem.Process
import platform.posix.system

@OptIn(ExperimentalCli::class, ExperimentalSerializationApi::class)
object RunCommand: Subcommand(name = "run", actionDescription = "Run script") {

    private val scriptName by argument(
        type = ArgType.String,
        fullName = "scriptName",
        description = ""
    )
    private val arguments by argument(
        type = ArgType.String,
        fullName = "arguments",
        description = ""
    ).vararg().optional()

    override fun execute() {
        val fs = FileSystem.SYSTEM
        val configFileName = "frconfig.json"
        val configPath = Process.execPath.toPath() / configFileName
        if (fs.exists(configPath)) {
            val configJson = Json.decodeFromBufferedSource<JsonObject>(fs.source(configPath).buffer())
            val scripts = configJson["scripts"]?.jsonObject?:run {
                println("`scripts` not found")
                return
            }
            val script = scripts[scriptName]?.jsonPrimitive?:run {
                println("`$scriptName` not found")
                return
            }
            if (script.isString) {
                val command = "${script.content} ${arguments.joinToString(" ")}"
                println("run $command")
                system(command)
            }
            else {
                println("`$scriptName` must be string")
                return
            }
        } else {
            println("$configFileName does not exit")
            println("Type `$programName ${InitCommand.name}`.")
        }
    }
}