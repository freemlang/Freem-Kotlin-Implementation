package parser

import parser.context.Context
import tyfe.result.Result

fun interface Parser<in Input, out Output, out Error> {
    suspend fun Context<Input>.parse(): Result<Output, Error>
}
