package org.freem.compiler.cli

fun struct() {
    val parser = ArgParser("frc")
}

class ArgParser(private val name: String) {
    fun parse(array: Array<String>) {

    }

    fun subCommand() {

    }

    fun option() {

    }

}

interface ParserResult {


    fun getBoolean(name: String): Boolean
    fun getShort(name: String): Short
    fun getInt(name: String): Int
    fun getLong(name: String): Long
    fun getFloat(name: String): Float
    fun getDouble(name: String): Double
    fun getChar(name: String): Char
    fun getString(name: String): String

    fun getBooleanOrNull(name: String): Boolean?
    fun getShortOrNull(name: String): Short?
    fun getIntOrNull(name: String): Int?
    fun getLongOrNull(name: String): Long?
    fun getFloatOrNull(name: String): Float?
    fun getDoubleOrNull(name: String): Double?
    fun getCharOrNull(name: String): Char?
    fun getStringOrNull(name: String): String?

}

class SubCommand {

}

class Option {

}