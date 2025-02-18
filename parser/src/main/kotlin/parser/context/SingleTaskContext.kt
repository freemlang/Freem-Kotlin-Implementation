package parser.context

import kotlinx.coroutines.CoroutineScope
import tyfe.option.None
import tyfe.option.Option
import tyfe.option.Some

internal class SingleTaskContext<out Input>
internal constructor(private val iterator: Iterator<Input>, coroutineScope: CoroutineScope) :
    Context<Input>(coroutineScope) {
    override suspend fun next(): Option<Input> {
        return if (iterator.hasNext()) Some(iterator.next()) else None
    }
}
