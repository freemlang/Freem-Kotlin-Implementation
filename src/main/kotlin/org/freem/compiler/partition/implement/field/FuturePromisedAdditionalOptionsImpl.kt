package org.freem.compiler.partition.implement.field

import org.freem.compiler.partition.interfaces.field.AdditionalOptions
import org.freem.compiler.partition.interfaces.field.FuturePromisedAdditionalOptions
import java.util.concurrent.Future
import kotlin.reflect.KProperty

internal class FuturePromisedAdditionalOptionsImpl<FutureType>: FuturePromisedAdditionalOptions<FutureType> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): Future<FutureType> {
        TODO("Not yet implemented")
    }

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