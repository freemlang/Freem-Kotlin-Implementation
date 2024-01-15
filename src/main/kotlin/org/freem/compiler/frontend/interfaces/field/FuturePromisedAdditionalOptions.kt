package org.freem.compiler.frontend.interfaces.field

import java.util.concurrent.Future
import kotlin.reflect.KProperty

interface FuturePromisedAdditionalOptions<FutureType>: AdditionalOptions {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Future<FutureType>
}

