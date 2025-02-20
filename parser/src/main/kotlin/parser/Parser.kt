package parser

import parser.context.Context

fun interface Parser<in Input, out Output> {
    suspend fun Context<Input>.parse(): Output
}
