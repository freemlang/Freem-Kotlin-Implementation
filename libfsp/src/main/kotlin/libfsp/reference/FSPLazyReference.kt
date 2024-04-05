package libfsp.reference

import java.util.*
import kotlin.collections.HashMap

internal class FSPLazyReference<Type> internal constructor(): FSPVariance<Type>() {
    private val valuePool: MutableMap<UUID, Lazy<Type>> = HashMap()

    internal fun enalble(uuid: UUID, lazy: Lazy<Type>) {
        if (valuePool.containsKey(uuid)) throw IllegalStateException("element already exist")
        valuePool[uuid] = lazy
    }

    internal fun disable(uuid: UUID) {
        if (!valuePool.containsKey(uuid)) throw IllegalStateException("cannot find element")
        valuePool.remove(uuid)
    }

    override fun get(uuid: UUID): Type {
        try {
            return valuePool.getValue(uuid).value
        } catch (e: NoSuchElementException) {
            throw IllegalStateException("cannot find element")
        }
    }

    override fun set(uuid: UUID, value: Type) {
        if (!valuePool.containsKey(uuid)) throw IllegalStateException("cannot find element")
        val lazyValue = lazy { value }
        lazyValue.value
        valuePool[uuid] = lazyValue
    }
}