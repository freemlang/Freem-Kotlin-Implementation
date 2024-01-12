package org.freem.compiler.frontend

import kotlin.reflect.KProperty

interface Partition<Return> {
    fun PartitionField.initialize(): Promise<Return>
}

abstract class Promise<Value> {
    protected abstract val promise: () -> Value
    fun get(): Value { TODO() }
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Value { TODO() }
}
private class PromiseWrapper<Value>(override val promise: () -> Value): Promise<Value>()
fun <Value> Promise(promise: () -> Value): Promise<Value> = PromiseWrapper(promise)

private class Field: PartitionField()

sealed class PartitionField {

    open val add: Add = AddWrapper
    private data object AddWrapper: Add
    sealed interface Add {
        infix fun static(string: String): AdditionalOptions { TODO() }
        infix fun static(char: Char): AdditionalOptions { TODO() }
        infix fun custom(condition: (Char) -> Boolean): AdditionalOptions { TODO() }
        infix fun dynamic(string: () -> String): AdditionalOptions { TODO() }
        infix fun <Return> partition(partition: Partition<Return>): AdditionalOptionsWithGetter<Return> { TODO() }
        infix fun field(field: PartitionField.() -> Unit): AdditionalOptions { TODO() }
        infix fun case(field: CaseField<Unit>.() -> Unit): AdditionalOptionsWithGetter<String> { TODO() }
        infix fun <Return> case(field: CaseField<Return>.() -> Unit): AdditionalOptionsWithGetter<Return> { TODO() }
    }
    sealed class CaseField<ReturnsType> {
        val case: Returns<ReturnsType> = ReturnsWrapper()
        private class ReturnsWrapper<ReturnsType>: Returns<ReturnsType>
        sealed interface Returns<ReturnsType> {
            infix fun <Type: ReturnsType> returns(value: Type): Add { TODO() }
        }
    }

    private class AdditionalOptionsWrapper: AdditionalOptions
    private class AdditionalOptionsWithGetterWrapper<Return>: AdditionalOptionsWithGetter<Return>

    sealed interface AdditionalOptionsWithGetter<Return>: AdditionalOptions {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): Promise<Return> { TODO() }
    }
    sealed interface AdditionalOptions {
        infix fun optional(optional: Boolean): AdditionalOptions { TODO() }
        infix fun repeat(range: IntRange): AdditionalOptions { TODO() }
        infix fun repeatMin(min: Int): AdditionalOptions { TODO() }
        infix fun repeatMax(max: Int): AdditionalOptions { TODO() }
        infix fun multiply(amount: Int): AdditionalOptions { TODO() }
    }

    fun newCapture(): CaptureObject {
        TODO()
    }
    sealed class CaptureObject: Promise<String>() {
        override val promise: () -> String = { "" }
        fun fin() { TODO() }
    }


}

class PartitionInterruption(message: String?, cause: Throwable?): Throwable(message, cause) {
    constructor(message: String?): this(message, null)
    constructor(cause: Throwable?): this(cause?.toString(), cause)
    constructor(): this(null, null)
}