package org.freem.compiler.frontend

abstract class DynamicTextCompiler<R>: DynamicCompiler<Char, R>() {
    fun compile(string: String): R = compile(string.iterator())
}
