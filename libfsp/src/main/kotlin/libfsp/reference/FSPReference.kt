package libfsp.reference

import java.util.NoSuchElementException
import java.util.UUID

internal class FSPReference<Type>: FSPVariance<Type>() {
    private val valuePool: MutableMap<UUID, Type> = HashMap()

    internal fun enable(uuid: UUID, value: Type) {
        if (valuePool.containsKey(uuid)) throw IllegalStateException("element already exist")
        valuePool[uuid] = value
    }

    internal fun disable(uuid: UUID) {
        if (!valuePool.containsKey(uuid)) throw IllegalStateException("cannot find element")
        valuePool.remove(uuid)
    }

    override fun get(uuid: UUID): Type {
        try {
            return valuePool.getValue(uuid)
        } catch (e: NoSuchElementException) {
            throw IllegalStateException("cannot find element")
        }
    }

    override fun set(uuid: UUID, value: Type) {
        if (!valuePool.containsKey(uuid)) throw IllegalStateException("cannot find element")
        valuePool[uuid] = value
    }
}