package parser

import typeful.option.None
import typeful.option.Option
import typeful.option.Some

fun interface Parser<out Input, out Output> {
    fun Context.next(input: Option<@UnsafeVariance Input>): State<Input, Output>
}

fun <Input, Output> Parser<Input, Output>.parse(input: Iterator<Input>): ParseResult<Output> {
    val queue = ArrayDeque<Parser<Input, Output>>()
    queue.add(this)
    while (true) {
        val current: Option<Input> = if (input.hasNext()) Some(input.next()) else None
        var index = 0
        while (index < queue.size) {
            val request = queue[index]
            val state = with(request) { Context.InternalObject.next(current) }
            when (state) {
                is State.ACCEPT -> {
                    if (current.isNone()) {
                        throw IllegalStateException("Cannot accept `None` value")
                    }
                    continue
                }
                is State.REQUEST -> {
                    queue.removeAt(index)
                    index -= 1
                    queue.addAll(state.requestArray)
                }
                is State.COMPLETE -> {
                    queue.clear()
                    return ParseResult(state.output, current.isNone())
                }
            }
            index += 1
        }
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
