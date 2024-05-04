package libfsp.reference

import java.util.*
import kotlin.collections.HashMap

class ImmutableReference<Value>: Reference<Value>() {
    private val memory = HashMap<UUID, Value>()

    override fun new(uuid: UUID, value: Value) {
        check(uuid !in memory) { "value is already exist" }
        memory[uuid] = value
    }

    override fun free(uuid: UUID) {
        check(uuid in memory) { "value is not exist" }
        memory.remove(uuid)
    }

    override fun get(uuid: UUID): Value {
        check(uuid in memory) { "value is not exist" }
        return memory.getValue(uuid)
    }
}
