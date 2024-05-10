package libfsp.reference

import java.util.*

class VarianceReference<Value> internal constructor(): ValueReference<Value>() {
    internal fun set(uuid: UUID, value: () -> Value) {
        check(uuid in memory) { "Reference is not allocated" }
        memory[uuid] = value
    }
}