package libfsp

import libfsp.Node.Parser
import java.util.*

class Node<Input, Return, Error> {

}
sealed class Element

sealed class Node<Input, Return, Error> {
    fun parse(input: Array<Input>) = parse_(input.asList())
    fun parse(input: ArrayList<Input>) = parse_(input)
    private fun parse_(input: List<Input>) {
        val parser = createParser(input, 0)
        val result = parser.parse()
        when (result) {
            is ParseSucceed -> return TODO("get return value from return node value")
            is ParseFailure ->
        }
    }

    abstract val returnNodeValue: NodeValue<Return>

    internal fun interface Parser<Input> {
        fun parse(): ParseResult
    }

    internal sealed interface ParseResult { val index: Int }
    internal data class ParseSucceed(override val index: Int, val hasNext: Boolean): ParseResult
    internal data class ParseFailure(override val index: Int): ParseResult

    internal abstract fun createParser(input: List<Input>, index: Int): Parser<Input>

    companion object {
        fun <Input> static(value: Input): Node<Input, Input, Unit> = TODO()
        fun <Input> static(vararg value: Input): Node<Input, List<Input>, Unit> = TODO()
        fun <Input> statics(iterable: Iterable<Input>): Node<Input, List<Input>, Unit> = TODO()
        fun <Input, Return> dynamic(generator: () -> Node<Input, Return, *>): Node<Input, Return, Unit> = TODO()
        fun <Input> conditional(condition: (Input) -> Boolean): Node<Input, Input, Unit> = TODO()
        fun <Input> sequence(): Node<Input, List<Input>, Unit> = TODO()
        fun <Input, Return, Error> optional(node: Node<Input, Return, Error>): Node<Input, Return?, Error> = TODO()
        operator fun <Input> invoke(constructor: context(NodeConstructorContext<Input>, Companion) () -> Unit): Node<Input, Unit, Unit> =
            TODO()

        operator fun <Input, Return> invoke(constructor: context(NodeConstructorContext<Input>, Companion) () -> NodeValue<Return>): Node<Input, Return, Unit> =
            TODO()
    }
}

sealed interface NodeValue<Type>

internal class NodeScope {
    val parent: NodeScope
    val children: List<NodeScope> get() = children_
    private val children_: MutableList<NodeScope> = LinkedList()

    private constructor(parent: NodeScope) {
        this.parent = parent
    }

    constructor() {
        this.parent = this
    }

    fun appendScope(): NodeScope {
        val child = NodeScope(this)
        children_ += child
        return child
    }
}

internal class StaticNode<Input>(private val value: Input) : Node<Input, Input>() {
    override fun createParser(input: List<Input>, index: Int) = Parser<Input> {
        if (input[index] == value) return@Parser ParseResult(index, succeed = true, hasNext = false)
        return@Parser ParseResult(index + 1, succeed = false, hasNext = false)
    }
}

internal class StaticListNode<Input>(private val values: Array<Input>) : Node<Input, List<Input>>() {
    override fun createParser(input: List<Input>, index: Int) = Parser<Input> {
        var index = index
        for (value in values) {
            if (input[index] != value) return@Parser ParseResult(
                index,
                succeed = false,
                hasNext = false
            )
            index += 1
        }
        return@Parser ParseResult(index, succeed = true, hasNext = false)
    }
}

internal class DynamicNode<Input>() : Node<Input, List<Input>>() {
    override fun createParser(input: List<Input>, index: Int) = Parser<Input> {

    }
}

internal class ConditionalNode<Input> : Node<Input, Input>() {
    override fun createParser(input: List<Input>, index: Int) = Parser<Input> {
        TODO("Not yet implemented")
    }
}

internal class OptionalNode<Input, Return> : Node<Input, Return?>() {
    override fun createParser(input: List<Input>, index: Int) = Parser<Input> {
        TODO("Not yet implemented")
    }
}

internal class ContainerNode<Input, Return>(private val tasks: List<Any>) : Node<Input, Return>() {
    override fun createParser(input: List<Input>, index: Int) = Parser<Input> {
        TODO("Not yet implemented")
    }
}

class NodeConstructorContext<Input> internal constructor() {
    val append = AppendTarget<Input>()

    class AppendTarget<Input> {
        infix fun <Return> node(node: Node<Input, Return>) {}
        infix fun task(task: () -> Unit) {}
    }
}


val testNode = Node<Char> {
    append node static('a')
    append node static('a', 'b')
}

fun test() {

}
