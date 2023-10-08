package org.freem.utils

import org.freem.utils.location.StringLocation

open class CompileException(message: String, val pathname: String? = null, val location: StringLocation? = null): Exception(message) {
    open val errorMessage = "${pathname?:"unknown path"}${location?.run { ":$row:$column:$index" }?:""}\n$message"
    fun printError() = println(errorMessage)
}