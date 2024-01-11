package org.freem.compiler.frontend

interface Partition<Return> {
    fun PartitionField.initialize(): Return
}

sealed class PartitionField {
    val add = Add
    object Add {
        infix fun static(string: String): AdditionalOptions { TODO() }
        infix fun static(char: Char): AdditionalOptions { TODO() }
        infix fun custom(condition: (Char) -> Boolean): AdditionalOptions { TODO() }
        infix fun <Return> partition(partition: Partition<Return>): AdditionalOptions { TODO() }
        infix fun field(field: PartitionField.() -> Unit): AdditionalOptions { TODO() }
        infix fun case(field: PartitionField.() -> Unit): AdditionalOptions { TODO() }
    }
    sealed class AdditionalOptions {
        infix fun repeat(range: IntRange): AdditionalOptions { TODO() }
        infix fun repeatMin(min: Int): AdditionalOptions { TODO() }
        infix fun repeatMax(max: Int): AdditionalOptions { TODO() }
        infix fun multiply(amount: Int): AdditionalOptions { TODO() }
    }

    val capture = Capture
    object Capture {
        infix fun use(field: PartitionField.() -> Unit): String { TODO() }
        infix fun start(id: String): CaptureObject { TODO() }
        infix fun fin(id: String) { TODO() }
        infix fun fin(captureObject: CaptureObject) { TODO() }
    }
    sealed class CaptureObject

    sealed class Promise<Type>
}

class Field: PartitionField()

class PartitionInterruption(message: String?, cause: Throwable?): Throwable(message, cause) {
    constructor(message: String?): this(message, null)
    constructor(cause: Throwable?): this(cause?.toString(), cause)
    constructor(): this(null, null)
}