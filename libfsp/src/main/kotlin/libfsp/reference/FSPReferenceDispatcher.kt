package libfsp.reference

import java.util.UUID

class FSPReferenceDispatcher internal constructor(private val uuid: UUID) {
    context(FSPReferenceDispatcher)
    val <Type> FSPValue<Type>.value: Type
        get() = get(uuid)

    context(FSPReferenceDispatcher)
    var <Type> FSPVariance<Type>.value: Type
        get() = get(uuid)
        set(value) { set(uuid, value) }
}
