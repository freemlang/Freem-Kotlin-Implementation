package org.freem.compiler.frontend.field

import java.util.concurrent.Future
import kotlin.reflect.KProperty

sealed interface AdditionalOptions {
    infix fun optional(optional: Boolean): AdditionalOptions
    infix fun repeat(range: IntRange): AdditionalOptions
    infix fun repeatMin(min: Int): AdditionalOptions
    infix fun repeatMax(max: Int): AdditionalOptions
    infix fun multiply(amount: Int): AdditionalOptions
}

internal class AdditionalOptionsImpl: AdditionalOptions {
    override fun optional(optional: Boolean): AdditionalOptions {
        TODO("Not yet implemented")
    }

    override fun repeat(range: IntRange): AdditionalOptions {
        TODO("Not yet implemented")
    }

    override fun repeatMin(min: Int): AdditionalOptions {
        TODO("Not yet implemented")
    }

    override fun repeatMax(max: Int): AdditionalOptions {
        TODO("Not yet implemented")
    }

    override fun multiply(amount: Int): AdditionalOptions {
        TODO("Not yet implemented")
    }
}

