package freem.partition.analyzer.field

import java.util.concurrent.Future
import kotlin.reflect.KProperty

class FuturePromisedAdditionalOptions<FutureType> internal constructor(): AdditionalOptions() {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Future<FutureType> {
        TODO("Not yet implemented")
    }
}

