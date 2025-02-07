package parser

interface Parser<Input, Output> {
    fun Context<Input>.read(): Output
}

fun <Input, Output> Parser<Input, Output>.parse(iterator: Iterator<Input>): Output {
    val context = Context(iterator)
    val output = context.read()
    return output
}

fun <Input, Output> Parser<Input, Output>.parse(iterable: Iterable<Input>): Output {
    val iterator = iterable.iterator()
    return parse(iterator)
}

fun <Output> Parser<Char, Output>.parse(string: String): Output {
    val iterator = string.iterator()
    return parse(iterator)
}
