package parser.context

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import parser.Parser
import sluice.Sluice
import tyfe.option.Option
import tyfe.option.Some

class Context<out Input>
internal constructor(
    private val coroutineScope: CoroutineScope,
    private val inputProvider: InputProvider<Input>,
) {
    suspend fun next(): Option<Input> {
        return inputProvider.next()
    }

    suspend inline fun <Output> use(parser: Parser<Input, Output>): Output {
        val context = this@Context
        val output = with(parser) { context.parse() }
        return output
    }

    val isActive: Boolean
        get() {
            return coroutineScope.isActive
        }

    companion object {
        @Suppress("NOTHING_TO_INLINE")
        inline fun <Input, Output> branch(parser: Parser<Input, Output>): Branch<Input, Output> {
            return Branch(parser)
        }
    }

    suspend fun useBranch(vararg branches: Branch<Input, *>) {
        val centralSluice = CentralSluice(branches.size.toUInt())
        val inputBox = InputBox<Input>()
        val jobs =
            branches.map { branch ->
                val parser = branch.parser
                val taskSluice = Sluice()
                val provider = SubInputProvider(taskSluice, centralSluice, inputBox)
                val job =
                    coroutineScope.launch {
                        val coroutineScope = this@launch
                        val context = Context(coroutineScope, provider)
                        // unsmart smartcast
                        branch.output = Some(with(parser) { context.parse() }) as Nothing
                        centralSluice.requiredAmount -= 1u
                    }
                Pair(taskSluice, job)
            }
        val processor = coroutineScope.launch { while (true) {} }
    }
}
