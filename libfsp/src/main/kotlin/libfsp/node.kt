package libfsp

sealed class FSPNode<Type, Return> {

    fun parse(input: Array<out Type>): Return {
        return parse()
    }

    fun parse(input: Iterable<Type>): Return {
        return parse()
    }

    fun parse(input: Iterator<Type>): Return {
        return parse()
    }

    private fun parse(): Return {
        TODO()
    }

    protected abstract fun createParser(parseNode: ParseNode): Parser

    protected class ParseNode {
        val parent: ParseNode

        constructor() {
            this.parent = this
        }

        private constructor(parent: ParseNode) {
            this.parent = parent
        }

        fun Child() = ParseNode(this)
    }

    protected interface Parser {
        fun parse(): Result

        data class Result(val succeed: Boolean)
    }

    companion object {
        operator fun <Type> invoke(constructor: context(ConstructorContext<Type>) () -> Unit): FSPNode<Type, Unit> {
            TODO()
        }

        operator fun <Type, Return> invoke(constructor: context(ConstructorContext<Type>) () -> FSPNodeReference<Return>): FSPNode<Type, Return> {
            TODO()
        }

        fun <Type> Static(value: Type, failure: (() -> Throwable)? = null): FSPNode<Type, Type> = TODO()
        fun <Type> Static(vararg value: Type, failure: (() -> Throwable)? = null): FSPNode<Type, List<Type>> = TODO()
        fun <Type> Static(iterable: Iterable<Type>, failure: (() -> Throwable)? = null): FSPNode<Type, List<Type>> =
            TODO()

        fun <Type> Conditional(condition: (Type) -> Boolean, failure: (() -> Throwable)? = null): FSPNode<Type, Type> =
            TODO()

        fun <Type> Sequence(failure: (() -> Throwable)? = null): FSPNode<Type, List<Type>> = TODO()
        fun <Type, Return> Optional(node: FSPNode<Type, Return>): FSPNode<Type, Return?> = TODO()
    }

    sealed class ConstructorContext<Type> {
        abstract val append: AppendTarget<Type>

        sealed interface AppendTarget<Type> {
            infix fun <Return> node(node: FSPNode<Type, Return>)
            infix fun task(task: () -> Unit)
//            infix fun <Return> task(task: ImmutableReturnTask<Return>): NodeValueDelegate<Return>
//            infix fun <Return> task(task: MutableReturnTask<Return>): NodeValueDelegate<Return>
        }

        fun static(value: Type, failure: (() -> Throwable)? = null): FSPNode<Type, Type> = TODO()
        fun static(vararg value: Type, failure: (() -> Throwable)? = null): FSPNode<Type, List<Type>> = TODO()
        fun static(iterable: Iterable<Type>, failure: (() -> Throwable)? = null): FSPNode<Type, List<Type>> = TODO()
        fun <Return> dynamic(
            constructor: context(ConstructorContext<Type>) () -> FSPNode<Type, Return>,
            failure: (() -> Throwable)? = null
        ): FSPNode<Type, Return> = TODO()

        fun conditional(condition: (Type) -> Boolean, failure: (() -> Throwable)? = null): FSPNode<Type, Type> = TODO()
        fun sequence(failure: (() -> Throwable)? = null): FSPNode<Type, List<Type>> = TODO()
        fun <Return> optional(node: FSPNode<Type, Return>): FSPNode<Type, Return?> = TODO()
    }

    protected class ConstructorContextClass<Type>(processes: MutableList<Process>) : ConstructorContext<Type>() {
        fun close() {
            appendTarget.close()
        }

        private val appendTarget = AppendTargetClass<Type>(processes)
        override val append: ConstructorContext.AppendTarget<Type> get() = appendTarget

        private class AppendTargetClass<Type>(private var processes_: MutableList<Process>?) :
            ConstructorContext.AppendTarget<Type> {
            fun close() {
                processes_ = null
            }

            private val processes get() = processes_!!

            override fun <Return> node(node: FSPNode<Type, Return>) {
                TODO("Not yet implemented")
            }

            override fun task(task: () -> Unit) {
                TODO("Not yet implemented")
            }
        }
    }
}


sealed interface FSPNodeReference<Type>
sealed interface FSPImmutableNodeReference<Type> : FSPNodeReference<Type>
sealed interface FSPMutableNodeReference<Type> : FSPNodeReference<Type>

//import java.util.*
//import kotlin.reflect.KProperty
//
//sealed class FSPNode<Type, Return> {
//    fun parse(input: Array<out Type>): Return = parse()
//    fun parse(input: Iterable<Type>): Return = parse()
//    fun parse(input: Iterator<Type>): Return = parse()
//    private fun parse(): Return {
//        val processor = Processor(processes)
//        TODO()
//    }
//
//    internal abstract val processes: List<Process>
//
//    internal fun interface Process {
//        fun execute()
//    }
//
//    internal class Processor {
//        private val parent: Processor
//        private val processes: List<Process>
//
//        constructor(processes: List<Process>) {
//            this.parent = this
//            this.processes = processes
//        }
//
//        private constructor(parent: Processor, processes: List<Process) {
//            this.parent = parent
//            this.processes = processes
//        }
//
//        fun Child(processes: List<Process>): Processor = Processor(this, processes)
//    }
//
//    sealed interface ConstructorContext<Type> {
//        val append: AppendTarget<Type>
//
//        sealed interface AppendTarget<Type> {
//            infix fun <Return> element(node: FSPElement<Type, Return>): NodeValueDelegate<Return>
//            infix fun task(task: () -> Unit)
//            infix fun <Return> task(task: ImmutableReturnTask<Return>): NodeValueDelegate<Return>
//            infix fun <Return> task(task: MutableReturnTask<Return>): NodeValueDelegate<Return>
//        }
//
//        class NodeValueDelegate<Type> {
//            operator fun getValue(thisRef: Any?, property: KProperty<*>): NodeValue<Type> {
//                TODO()
//            }
//        }
//    }
//
//    protected class ConstructorContextClass<Type>(processes: MutableList<Process>) : ConstructorContext<Type> {
//        fun close() {
//            appendTarget.close()
//        }
//
//        private val appendTarget = AppendTargetClass<Type>(processes)
//        override val append: ConstructorContext.AppendTarget<Type> get() = appendTarget
//
//        private class AppendTargetClass<Type>(private var processes_: MutableList<Process>?) :
//            ConstructorContext.AppendTarget<Type> {
//            fun close() {
//                processes_ = null
//            }
//
//            private val processes get() = processes_!!
//
//            override fun <Return> element(node: FSPElement<Type, Return>): ConstructorContext.NodeValueDelegate<Return> {
//                TODO("Not yet implemented")
//            }
//
//            override fun task(task: () -> Unit) {
//                TODO("Not yet implemented")
//            }
//
//            override fun <Return> task(task: ImmutableReturnTask<Return>): ConstructorContext.NodeValueDelegate<Return> {
//                TODO("Not yet implemented")
//            }
//
//            override fun <Return> task(task: MutableReturnTask<Return>): ConstructorContext.NodeValueDelegate<Return> {
//                TODO("Not yet implemented")
//            }
//        }
//    }
//
//    class Release<Type>(constructor: context(ConstructorContext<Type>, FSPElement.ConstructorContext<Type>) () -> Unit) :
//        FSPNode<Type, Unit>() {
//        override val processes: List<Process>
//
//        init {
//            val processes = LinkedList<Process>()
//            val context = ConstructorContextClass<Type>(processes)
//            constructor(context, FSPElement.getConstructorContext())
//            context.close()
//            this.processes = processes
//        }
//
//
//    }
//
//    class Capture<Type, Return>(constructor: context(ConstructorContext<Type>, FSPElement.ConstructorContext<Type>) () -> NodeValue<Return>) :
//        FSPNode<Type, Return>() {
//        override val processes: List<Process>
//        private val returnReference: NodeValue<Return>
//
//        init {
//            val processes = LinkedList<Process>()
//            val context = ConstructorContextClass<Type>(processes)
//            this.returnReference = constructor(context, FSPElement.getConstructorContext())
//            context.close()
//            this.processes = processes
//        }
//    }
//}
//
//sealed interface NodeValue<Type>
//sealed interface ImmutableNodeValue<Type> : NodeValue<Type>
//sealed interface MutableNodeValue<Type> : NodeValue<Type>
//
//sealed class FSPElement<Input, Return> {
//    protected abstract val returnNodeValue: ImmutableNodeValue<Return>
//    abstract fun <Class : Throwable> attachThrowable(block: () -> Class): FSPElement<Input, Return>
//
//    internal class Partition<Input> {
//        val parent: Partition<Input>
//        val parser: Parser<Input>
//
//        constructor(parser: Parser<Input>) {
//            this.parent = this
//            this.parser = parser
//        }
//
//        private constructor(parent: Partition<Input>, parser: Parser<Input>) {
//            this.parent = parent
//            this.parser = parser
//        }
//
//        fun createChild(parser: Parser<Input>) = Partition(this, parser)
//
//        interface Parser<Input> {
//            fun parse(): Result
//
//            sealed interface Result {
//                val index: Int
//
//                data class Succeed(override val index: Int, val hasNext: Boolean) : Result
//                data class Failure(override val index: Int) : Result
//            }
//        }
//    }
//
//    internal abstract fun createPartitionParser(input: List<Input>, index: Int): Partition.Parser<Input>
//
//    sealed class ConstructorContext<Type> {
//        fun static(value: Type, failure: (() -> Throwable)? = null): FSPElement<Type, Type> = TODO()
//        fun static(vararg value: Type, failure: (() -> Throwable)? = null): FSPElement<Type, List<Type>> = TODO()
//        fun static(iterable: Iterable<Type>, failure: (() -> Throwable)? = null): FSPElement<Type, List<Type>> = TODO()
//        fun <Return> dynamic(
//            constructor: context(FSPNode.ConstructorContext<Type>, ConstructorContext<Type>) () -> FSPElement<Type, Return>,
//            failure: (() -> Throwable)? = null
//        ): FSPElement<Type, Return> = TODO()
//
//        fun conditional(condition: (Type) -> Boolean, failure: (() -> Throwable)? = null): FSPElement<Type, Type> =
//            TODO()
//
//        fun sequence(failure: (() -> Throwable)? = null): FSPElement<Type, List<Type>> = TODO()
//        fun <Return> optional(node: FSPElement<Type, Return>): FSPElement<Type, Return?> = TODO()
//
//        fun <Return> imut(block: () -> Return): ImmutableReturnTask<Return> {
//            TODO()
//        }
//
//        fun <Return> mut(block: () -> Return): MutableReturnTask<Return> {
//            TODO()
//        }
//    }
//
//    private data object ConstructorContextObject : ConstructorContext<Nothing>()
//
//    internal companion object {
//        fun <Input> getConstructorContext() =
//            @Suppress("UNCHECKED_CAST") (ConstructorContextObject as ConstructorContext<Input>)
//    }
//}
//
//
//internal sealed interface Task<Return>
//class ImmutableReturnTask<Return> : Task<Return>
//class MutableReturnTask<Return> : Task<Return>
//
//
//val testNode = FSPNode.Release<Char> {
//    append element static('a')
//    val ab by append element static('a', 'b')
//    val test by append task imut { mutableListOf<Int>() }
//    val test2 by append task mut { }
//    append task {
//        println("test")
//    }
//}
