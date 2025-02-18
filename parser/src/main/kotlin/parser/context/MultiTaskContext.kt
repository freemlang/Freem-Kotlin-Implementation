package parser.context

import kotlinx.coroutines.CoroutineScope
import sluice.Sluice
import tyfe.option.Option

internal class MultiTaskContext<out Input>
internal constructor(
    coroutineScope: CoroutineScope,
    private val taskSluice: Sluice,
    private val centralSluice: Any,
) : Context<Input>(coroutineScope) {
    override suspend fun next(): Option<Input> {
        taskSluice.close()
        TODO()
    }
}
