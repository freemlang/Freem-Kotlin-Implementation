package parser

import tyfe.option.Option

fun interface Parser<out Input, out Output> {
    fun Context.next(input: Option<@UnsafeVariance Input>): State<Input, Output>
}
