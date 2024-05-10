package libfsp.reference

import java.util.*

class SingletonReference<Value> internal constructor(private val value: Value): Reference<Value>() {
    override fun get(uuid: UUID): Value = value
}