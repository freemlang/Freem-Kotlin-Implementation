package libfsp.reference

import java.util.*

data object FSPUnit: FSPVariance<Unit>() {
    override fun get(uuid: UUID) = Unit
    override fun set(uuid: UUID, value: Unit) = Unit
}