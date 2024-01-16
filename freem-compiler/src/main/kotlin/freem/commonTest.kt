package freem

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun main() {
    val a: Int
    Test.test {
        a = 0
    }
}

object Test {
    @OptIn(ExperimentalContracts::class)
    infix fun test(block: () -> Unit) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
    }
}
