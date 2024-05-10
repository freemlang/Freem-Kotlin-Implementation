package libfsp.reference

import java.util.*
import kotlin.collections.HashMap

class ConstantReference<Value> internal constructor(): Reference<Value>() {
    private val memory = HashMap<UUID, Value>()

    internal fun alloc(uuid: UUID, value: Value) {
        check(uuid !in memory) { "Reference is already allocated" }
        memory[uuid] = value
    }

    internal fun free(uuid: UUID) {
        check(uuid in memory) { "Reference is not allocated" }
        memory.remove(uuid)
    }

    override fun get(uuid: UUID): Value {
        check(uuid in memory) { "Reference is not allocated" }
        return memory.getValue(uuid)
    }
}