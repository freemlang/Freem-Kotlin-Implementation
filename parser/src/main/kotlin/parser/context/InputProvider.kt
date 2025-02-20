package parser.context

import tyfe.option.Option

internal sealed interface InputProvider<out Input> {
    suspend fun next(): Option<Input>
}
