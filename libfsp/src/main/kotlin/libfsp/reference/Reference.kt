package libfsp.reference

import java.util.*

sealed class Reference<Value> {
    internal abstract fun get(uuid: UUID): Value
}