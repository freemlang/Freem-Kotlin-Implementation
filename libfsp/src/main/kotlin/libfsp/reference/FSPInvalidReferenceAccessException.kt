package libfsp.reference

class FSPInvalidReferenceAccessException internal constructor(
    override val message: String?,
    override val cause: Throwable?
): Exception() {
    internal constructor(message: String?): this(message, null)
    internal constructor(cause: Throwable?): this(cause?.message, cause)
    internal constructor(): this(null, null)
}