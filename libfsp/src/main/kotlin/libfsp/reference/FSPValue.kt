package libfsp.reference

import java.util.UUID

sealed class FSPValue<Type> {
    protected abstract val valuePool: MutableMap<UUID, Type>
    internal fun register(uuid: UUID, value: Type) {
        if (valuePool.containsKey(uuid)) throw IllegalArgumentException("value already exist")
        valuePool[uuid] = value
    }
    internal fun get(uuid: UUID): Type {
        return valuePool.getValue(uuid)
    }
}