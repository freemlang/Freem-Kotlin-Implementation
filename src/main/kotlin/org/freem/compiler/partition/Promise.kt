package org.freem.compiler.partition

@Deprecated("Not Using")
abstract class Promise<Value> {
    protected abstract val promise: () -> Value
    private var value: Value? = null
    private var isInitialState = true
    fun get(): Value {
        if (isInitialState) {
            value = promise()
            isInitialState = false
        }
        return value!!
    }
}
private class PromiseWrapper<Value>(override val promise: () -> Value): Promise<Value>()
fun <Value> Promise(promise: () -> Value): Promise<Value> = PromiseWrapper(promise)