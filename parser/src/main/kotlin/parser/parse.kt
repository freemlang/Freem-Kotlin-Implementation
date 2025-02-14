package parser

import tyfe.option.None
import tyfe.option.Option
import tyfe.option.Some

fun <Input, Output> Parser<Input, Output>.parse(input: Iterator<Input>): ParseResult<Output> {
    val queue = ArrayDeque<Parser<Input, Output>>()
    queue.add(this)
    while (true) {
        val current: Option<Input> = if (input.hasNext()) Some(input.next()) else None
        var index = 0
        while (index < queue.size) {
            val request = queue[index]
            val context = Context.Instance
            val state = with(request) { context.next(current) }
            when (state) {
                is State.ACCEPT -> {
                    check(current.isNone()) { "Cannot accept `None` value" }
                    continue
                }
                is State.REQUEST -> {
                    queue.removeAt(index)
                    index -= 1
                    queue.addAll(state.requests)
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
