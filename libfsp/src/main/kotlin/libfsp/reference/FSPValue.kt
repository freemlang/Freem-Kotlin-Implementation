package libfsp.reference

import java.util.*

sealed class FSPValue<Type> {
    internal abstract fun get(uuid: UUID): Type
}