package libfsp.reference

import java.util.UUID

sealed class FSPVariance<Type>: FSPValue<Type>() {
    internal abstract fun set(uuid: UUID, value: Type)
}