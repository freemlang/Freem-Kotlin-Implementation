package libfsp.reference

import java.util.UUID

abstract class Reference<Value> {
    abstract fun new(uuid: UUID, value: Value)
    abstract fun free(uuid: UUID)

    abstract fun get(uuid: UUID): Value
}