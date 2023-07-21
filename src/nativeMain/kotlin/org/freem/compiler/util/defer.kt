package org.freem.compiler.util

fun deferBlock(block: DeferArea.() -> Unit) {
    val defer = DeferBlock()
    try { defer.block() }
    finally { for (deferFunction in defer.deferStack) deferFunction() }
}

interface DeferArea { fun defer(block: () -> Unit) }
private class DeferBlock: DeferArea {
    val deferStack: MutableList<() -> Unit> = mutableListOf()
    override fun defer(block: () -> Unit) {
        deferStack.add(block)
    }
}