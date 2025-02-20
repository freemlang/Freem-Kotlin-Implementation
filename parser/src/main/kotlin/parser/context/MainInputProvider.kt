package parser.context

import tyfe.option.None
import tyfe.option.Option
import tyfe.option.Some

internal class MainInputProvider<out Input>(private val iterator: Iterator<Input>) :
    InputProvider<Input> {
    override suspend fun next(): Option<Input> {
        return try {
            if (iterator.hasNext()) Some(iterator.next()) else None
        } catch (_: Throwable) {
            None
        }
    }
}
