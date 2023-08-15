package org.freem.tools.scope

fun deferBlock(block: DeferScope.() -> Unit) {
    val defer = DeferBlock()
    try { defer.block() }
    finally { for (deferFunction in defer.deferStack) deferFunction() }
}

interface DeferScope { fun defer(block: () -> Unit) }
private class DeferBlock: DeferScope {
    val deferStack: MutableList<() -> Unit> = mutableListOf()
    override fun defer(block: () -> Unit) {
        deferStack.add(block)
    }
}