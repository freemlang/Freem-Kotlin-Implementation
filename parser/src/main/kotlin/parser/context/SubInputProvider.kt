package parser.context

import coroutines.sluice.Sluice
import tyfe.option.Option

internal class SubInputProvider<out Input>(
    private val sluce: Sluice,
    private val centralSluice: ThresholdSluice,
    private val inputBox: InputBox<Input>,
) : InputProvider<Input> {
    override suspend fun next(): Option<Input> {
        centralSluice.open()
        sluce.close()
        return inputBox.input
    }
}
