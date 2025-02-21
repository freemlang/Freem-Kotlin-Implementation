package parser.context

import coroutines.sluice.ListedSluice
import coroutines.sluice.Sluice
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import parser.Parser
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

    /** helper function for useBranch */
    @Suppress("NOTHING_TO_INLINE")
    private inline fun <Output> branchMapper(
        branch: Branch<Input, Output>,
        inputBox: InputBox<Input>,
        centralSluice: ListedSluice,
    ): Pair<Sluice, Job> {
        val parser = branch.parser
        val taskSluice = Sluice()
        val provider = SubInputProvider(taskSluice, centralSluice, inputBox)
        val job =
            coroutineScope.launch {
                try {
                    val coroutineScope = this@launch
                    val context = Context(coroutineScope, provider)
                    branch.output = Some(with(parser) { context.parse() })
                } finally {
                    centralSluice.open()
                }
            }
        return Pair(taskSluice, job)
    }

    suspend fun useBranch(vararg branches: Branch<Input, *>) {
        val inputBox = InputBox<Input>()
        val centralSluice = ListedSluice()
        var tasks = branches.map { branch -> branchMapper(branch, inputBox, centralSluice) }
        val processor = coroutineScope.launch { while (true) {} }
    }
}
