package libfsp.reference

import java.util.UUID

class FSPReferenceAccessDispatcher internal constructor(private val uuid: UUID) {
    /**
     * @throws FSPInvalidReferenceAccessException
     */
    context(FSPReferenceAccessDispatcher)
    val <Type> FSPValue<Type>.value: Type
        get() = get(this)

    /**
     * @throws FSPInvalidReferenceAccessException
     */
    context(FSPReferenceAccessDispatcher)
    var <Type> FSPVariance<Type>.value: Type
        get() = get(this)
        set(value) = set(this, value)

    internal fun <Type> get(value: FSPValue<Type>): Type {
        try {
            return value.get(uuid)
        } catch (e: Throwable) {
            throw FSPInvalidReferenceAccessException(e)
        }
    }

    internal fun <Type> set(variance: FSPVariance<Type>, value: Type) {
        try {
            variance.set(uuid, value)
        } catch (e: Throwable) {
            throw FSPInvalidReferenceAccessException(e)
        }
    }
}
