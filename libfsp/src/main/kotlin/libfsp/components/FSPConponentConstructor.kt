package libfsp.components

import libfsp.components.contexts.FSPEntityConstructDispatcher
import libfsp.reference.FSPUnit
import libfsp.reference.FSPValue
import java.util.LinkedList

@Suppress("INAPPLICABLE_JVM_NAME")
@JvmName("fspnewt")
fun <Type, Return> fspnew(constructor: context(FSPEntityConstructDispatcher<Type>) () -> FSPValue<Return>): FSPComponent<Type, Return> {
    val components = LinkedList<FSPComponent<Type, *>>()
    val dispatcher = FSPEntityConstructDispatcher(components)
    val returnValue = constructor(dispatcher)



}

@Suppress("INAPPLICABLE_JVM_NAME")
@JvmName("fspnewu")
fun <Type> fspnew(constructor: context(FSPEntityConstructDispatcher<Type>) () -> Unit): FSPComponent<Type, Unit> {
    return fspnew<Type, Unit> {
        constructor(getThis())
        FSPUnit
    }
}

context(Dispatcher)
@Suppress("NOTHING_TO_INLINE")
private inline fun <Dispatcher> Dispatcher.getThis() = this