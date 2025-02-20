package parser

import kotlinx.coroutines.runBlocking
import parser.context.Context
import parser.context.MainInputProvider

fun <Input, Output> Parser<Input, Output>.parse(iterator: Iterator<Input>): Output {
    return runBlocking {
        val provider = MainInputProvider(iterator)
        val coroutineScope = this@runBlocking
        val context = Context(coroutineScope, provider)
        val output = context.parse()
        output
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <Input, Output> Parser<Input, Output>.parse(iterable: Iterable<Input>): Output {
    val iterator = iterable.iterator()
    val output = parse(iterator)
    return output
}

@Suppress("NOTHING_TO_INLINE")
inline fun <Output> Parser<Char, Output>.parse(string: String): Output {
    val iterator = string.iterator()
    val output = parse(iterator)
    return output
}
