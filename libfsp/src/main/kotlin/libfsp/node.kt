package libfsp

//import java.util.*
//
//internal interface NodeProcessor {
//    fun process(): NodeProcessResult
//}
//
//data class NodeProcessResult(val index: UInt, val succeed: Boolean, val hasNext: Boolean)
//
//sealed class Node<Input, Return> {
//    internal abstract fun createProcessor(input: List<Input>): NodeProcessor
//}
//
//class TaskNode(val task: () -> Unit) : Node<Nothing, Nothing>() {
//    override fun createProcessor(input: List<Nothing>): NodeProcessor {
//        TODO("Not yet implemented")
//    }
//}
//
//class ContainerNode<Input, Return> : Node<Input, Return> {
//
//    private val nodes: Array<Node<Input, *>>
//    private val returnPromise: NodePromise<Return>
//
//    constructor(constructor: context(ConstructorContext<Input>) () -> NodePromise<Return>) {
//        val nodes = LinkedList<Node<Input, *>>()
//        val context = ConstructorContext(nodes)
//        val returnPromise = constructor(context)
//        this.nodes = nodes.toTypedArray()
//        this.returnPromise = returnPromise
//    }
//
//    constructor(constructor: context(ConstructorContext<Input>) () -> Unit) {
//        val nodes = LinkedList<Node<Input, *>>()
//        val context = ConstructorContext(nodes)
//        constructor(context)
//        this.nodes = nodes.toTypedArray()
//        this.returnPromise = NodePromise()
//    }
//
//    class ConstructorContext<Input>(nodes: MutableList<Node<Input, *>>) {
//        val append = ConstructManager(nodes)
//
//        class ConstructManager<Input>(private val nodes: MutableList<Node<Input, *>>) {
//            infix fun <Return> node(node: Node<Input, Return>): NodePromise<Return> {
//                TODO()
//            }
//
//            infix fun task(task: () -> Unit) {
//
//            }
//        }
//    }
//
//    private class Processor<Input>(private val input: List<Input>, private val children: Array<Node<Input, *>>) :
//        NodeProcessor {
//        override fun process(): NodeProcessResult {
//            TODO("Not yet implemented")
//        }
//    }
//
//    override fun createProcessor(input: List<Input>): NodeProcessor = Processor(input, children)
//}
//
//class NodePromise<Type>

// prototype
val a = node {
    val numberPromise by append node Conditional { it.isDigit } then { it.digitToInt() }
    append node Dynamic {
        val number by numberPromise
        "${number * 2}".toList()
    }
    append node Optional {
        thisNode@ node
    }
}

fun test() {

}
