package org.freem.tools.command

import org.freem.Process

//fun test() {
//    val executor = CommandExecutorBuilder("test")
//        .build()
//
//
//
//    executor.execute(Process.args)
//}
//
//class CommandExecutorBuilder(
//    private var name: String? = null
//) {
//    private class Parser {
//
//    }
//
//    fun setName(name: String): CommandExecutorBuilder {
//        this.name = name
//        return this
//    }
//
//    fun addSubCommand(subCommand: SubCommand): CommandExecutorBuilder {
//
//        return this
//    }
//
//    fun setDefaultCommand(command: Command): CommandExecutorBuilder {
//
//        return this
//    }
//
//    fun build(): CommandExecutor = CommandExecutor(
//        name = name?: throw IllegalStateException("Property `name` not defined")
//
//    )
//}
//
//interface CommandExecutor {
//    val name: String
//    val isParsed: Boolean
//
//    fun execute(arguments: Array<String>)
//}
//
//interface Command {
//    fun execute()
//}
//
//interface SubCommand: Command {
//    val name: String
//    val alias: List<String>?
//    val description: String?
//}
//
//abstract class CommandAdapter: Command {
//    override fun execute() {}
//}
//
//abstract class SubCommandAdapter(
//    override val name: String,
//    override val alias: List<String>? = null,
//    override val description: String? = null
//): CommandAdapter(), SubCommand
//
//object Commands {
//    object Command {
//        class Help: Command {
//
//        }
//    }
//    object SubCommand {
//
//    }
//    object Option {
//
//    }
//}
