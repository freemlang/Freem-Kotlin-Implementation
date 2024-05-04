package libfsp.reference

import java.util.UUID
import kotlin.reflect.KProperty

class ReferenceAccessibleScope internal constructor(private val uuid: UUID) {
    operator fun <Value> Reference<Value>.invoke(): Value = get(uuid)
    operator fun <Value> MutableReference<Value>.invoke(value: Value) = set(uuid, value)

    operator fun <Value> Reference<Value>.getValue(thisRef: Any?, property: KProperty<*>): Value = get(uuid)
    operator fun <Value> MutableReference<Value>.setValue(thisRef: Any?, property: KProperty<*>, value: Value) = set(uuid, value)
}