package parser.context

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlinx.coroutines.CoroutineScope
import parser.Parser
import parser.context.branchcontext.BranchContext
import tyfe.option.Option
import tyfe.result.Result

sealed class Context<out Input>(private val coroutineScope: CoroutineScope) {
    abstract suspend fun next(): Option<Input>

    suspend fun <Output, Error> call(parser: Parser<Input, Output, Error>): Result<Output, Error> {
        return with(parser) { this@Context.parse() }
    }

    @OptIn(ExperimentalContracts::class)
    suspend fun <Return> branch(block: suspend BranchContext<Input>.() -> Return): Return {
        contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
        val context = BranchContext<Input>()
        context.block()
        TODO()
    }
}
