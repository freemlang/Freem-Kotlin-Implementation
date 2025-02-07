package parser

import util.rusty.option.None
import util.rusty.option.Option
import util.rusty.option.Some

class Context<Input> internal constructor(iterator: Iterator<Input>) : Iterator<Input> {
    private var current: Option<Input> = if (iterator.hasNext()) Some(iterator.next()) else None

    fun peek(): Option<Input> {
        return current
    }

    override fun next(): Input {
        when (val item = current) {
            is Some -> return item.value
            is None -> throw IllegalStateException()
        }
    }

    override fun hasNext(): Boolean {
        return current is Some
    }
}
