package org.freem.compiler.frontend

class PartitionInterruption(message: String?, cause: Throwable?): Throwable(message, cause) {
    constructor(message: String?): this(message, null)
    constructor(cause: Throwable?): this(cause?.toString(), cause)
    constructor(): this(null, null)
}