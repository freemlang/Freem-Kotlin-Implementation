package libfsp.reference

import java.util.*

class MutableReference<Value> internal constructor(): Reference<Value>() {
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

    fun set(uuid: UUID, value: Value) {
        check(uuid in memory) { "value is not exist" }
        memory[uuid] = value
    }
}