package libfsp.reference

import java.util.*
import kotlin.collections.HashMap

internal class FSPLazyReference<Type> internal constructor(): FSPVariance<Type>() {
    private val valuePool: MutableMap<UUID, Lazy<Type>> = HashMap()
    internal fun register(uuid: UUID, lazy: Lazy<Type>) {
        if (valuePool.containsKey(uuid)) throw IllegalStateException("value already exist")
        valuePool[uuid] = lazy
    }

    override fun get(uuid: UUID): Type {
        return valuePool.getValue(uuid).value
    }

    override fun set(uuid: UUID, value: Type) {
        if (!valuePool.containsKey(uuid)) throw IllegalStateException("cannot find value")
        val lazyValue = lazy { value }
        lazyValue.value
        valuePool[uuid] = lazyValue
    }
}