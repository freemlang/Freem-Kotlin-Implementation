package parser

import java.util.*
import util.rusty.option.None
import util.rusty.option.Option
import util.rusty.option.Some

fun interface Parser<out Input, out Output> {
    fun Context.next(input: Option<@UnsafeVariance Input>): State<Input, Output>
}

fun <Input, Output> Parser<Input, Output>.parse(input: Iterator<Input>): ParseResult<Output> {
    val queue = LinkedList<Parser<Input, Output>>()
    val finQueue = LinkedList<Parser<Input, Output>>()
    queue.add(this)
    while (true) {
        val current: Option<Input> = if (input.hasNext()) Some(input.next()) else None
        while (true) {
            val request = queue.removeFirstOrNull() ?: break
            val state = with(request) { ContextObject.next(current) }
            when (state) {
                is State.ACCEPT ->
                    if (current.isNone()) throw IllegalStateException("Cannot accept `None` value")
                is State.COMPLETE -> return ParseResult(state.output, current.isNone())
                is State.REQUEST -> queue.addAll(state.requestArray)
            }
            finQueue.add(request)
        }
        queue.addAll(finQueue)
        finQueue.clear()
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <Input, Output> Parser<Input, Output>.parse(
    input: Iterable<Input>
): ParseResult<Output> {
    val iterator = input.iterator()
    return parse(iterator)
}

@Suppress("NOTHING_TO_INLINE")
inline fun <Output> Parser<Char, Output>.parse(input: String): ParseResult<Output> {
    val iterator = input.iterator()
    return parse(iterator)
}
