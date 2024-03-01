package libfsp.components

class FSPInvalidInputException internal constructor(
    val index: Int,
    override val message: String?,
    override val cause: Throwable?
): Exception()
