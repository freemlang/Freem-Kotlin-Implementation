package org.freem.compiler.frontend

sealed interface P<Target>: Iterator<Target> {
    fun scope(vararg blocks: P<Target>.() -> Unit)
    fun scope(block: P<Target>.() -> Unit)

    fun capture(block: P<Target>.() -> Unit): Array<Target>

    fun need(target: Target, interruptMessage: String? = null)
    fun need(interruptMessage: String? = null, condition: (target: Target) -> Boolean)
    fun interrupt(message: String? = null): Nothing
}

fun P<Char>.need(target: String, interruptMessage: String? = null) {
    scope {
        for (char in target) need(char)
    }
}

private class PPP<Target>(private val array: Array<Target>, var index: Int): P<Target> {

    override fun hasNext(): Boolean = index < array.size
    override fun next(): Target = array[index++]

    override fun scope(block: P<Target>.() -> Unit) {
        val indexBackup = index
        try {
            block()
        } catch (throwable: Throwable) {
            index = indexBackup
            throw throwable
        }
    }

    override fun scope(vararg blocks: P<Target>.() -> Unit) {
        if (blocks.isEmpty()) return

        for (block in blocks) {
            try {
                scope(block)
                return
            } catch (interruption: PInterruption) {
                continue
            }
        }

        interrupt()
    }

    override fun capture(block: P<Target>.() -> Unit): Array<Target> {
        val startIndex = index
        block()
        return array.sliceArray(startIndex..<index)
    }

    override fun need(target: Target, interruptMessage: String?) = need(interruptMessage) { it == target }
    override fun need(interruptMessage: String?, condition: (target: Target) -> Boolean) {
        if (!hasNext() || !condition(next())) interrupt(interruptMessage)
    }

    override fun interrupt(message: String?): Nothing = throw PInterruption(message)
}

class PP<Target>(val block: P<Target>.() -> Unit) {

    fun run(array: Array<Target>) {
        val ppp = PPP(array, 0)
        ppp.block()
        if (ppp.index != array.size) throw IllegalStateException("array item remained")
    }

}

class PInterruption(override val message: String?): Throwable()