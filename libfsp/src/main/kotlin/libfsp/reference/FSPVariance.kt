package libfsp.reference

import java.util.UUID

sealed class FSPVariance<Type>: FSPValue<Type>() {
    internal fun set(uuid: UUID, value: Type) {
        if (!valuePool.containsKey(uuid)) throw NoSuchElementException("invalid variance")
        valuePool[uuid] = value
    }
}