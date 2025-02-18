package parser

import kotlinx.coroutines.runBlocking
import parser.context.SingleTaskContext
import tyfe.result.Result

fun <Input, Output, Error> Parser<Input, Output, Error>.parse(
    iterator: Iterator<Input>
): Result<Output, Error> {
    return runBlocking {
        val context = SingleTaskContext(iterator)
        val result = context.parse()
        return@runBlocking result
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <Input, Output, Error> Parser<Input, Output, Error>.parse(
    iterable: Iterable<Input>
): Result<Output, Error> {
    val iterator = iterable.iterator()
    return parse(iterator)
}

@Suppress("NOTHING_TO_INLINE")
inline fun <Output, Error> Parser<Char, Output, Error>.parse(
    string: String
): Result<Output, Error> {
    val iterator = string.iterator()
    return parse(iterator)
}
