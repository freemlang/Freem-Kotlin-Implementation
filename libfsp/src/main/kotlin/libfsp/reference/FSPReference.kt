package libfsp.reference

import java.util.UUID

internal class FSPReference<Type>: FSPVariance<Type>() {
    private val valuePool: MutableMap<UUID, Type> = HashMap()

    internal fun register(uuid: UUID, value: Type) {
        if (valuePool.containsKey(uuid)) throw IllegalStateException("value already exist")
        valuePool[uuid] = value
    }

    override fun get(uuid: UUID): Type {
        return valuePool.getValue(uuid)
    }

    override fun set(uuid: UUID, value: Type) {
        if (!valuePool.containsKey(uuid)) throw IllegalStateException("cannot find value")
        valuePool[uuid] = value
    }
}