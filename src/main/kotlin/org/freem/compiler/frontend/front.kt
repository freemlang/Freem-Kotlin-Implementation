package org.freem.compiler.frontend

import org.freem.compiler.frontend.module.ExtensionModule
import org.freem.compiler.frontend.module.MainModule
import kotlin.properties.Delegates

class CompilerBuilder<T, M: MainModule<T, D>, D>() {

    constructor(mainModule: M): this() {
        mainModule(mainModule)
    }

    private val mainModule: M by Delegates.notNull()
    val data: D get() = mainModule.data

    fun mainModule(module: M): CompilerBuilder<T, M, D> {

        return this
    }

    fun addModule(module: ExtensionModule<T, M>): CompilerBuilder<T, M, D> {

        return this
    }

    fun build(): Compiler<T, M, D> { TODO() }
}

class Compiler<T, M: MainModule<T, D>, D>