package libfsp.components

import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPUnit
import libfsp.reference.FSPValue
import java.util.LinkedList

@Suppress("INAPPLICABLE_JVM_NAME")
@JvmName("fspnewt")
fun <Type, Return> fspnew(constructor: context(FSPComponentListConstructDispatcher<Type>) () -> FSPValue<Return>): FSPComponent<Type, Return> {
    val components = LinkedList<FSPComponent<Type, *>>()
    val dispatcher = FSPComponentListConstructDispatcher(components)
    val returnValue = constructor(dispatcher)

    if (components.isEmpty()) return FSPReturnDelegateComponent(FSPEmptyComponent, returnValue)
    if (components.size == 1) return FSPReturnDelegateComponent(components[0], returnValue)

    val componentBuffer = LinkedList<FSPComponent<Type, *>>()
    val constBuffer = LinkedList<Type>()

    fun uploadConstFromBuffer() {
        if (constBuffer.isNotEmpty()) {
            componentBuffer.add(FSPConstant(constBuffer.toList()))
            constBuffer.clear()
        }
    }

    for (component in components) {
        if (component is FSPConstant) {
            constBuffer.addAll(component.content)
            continue
        }
        uploadConstFromBuffer()
        componentBuffer.add(component)
    }
    uploadConstFromBuffer()

    val result = componentBuffer.toList()
    componentBuffer.clear()

    return when (components.size) {
        1 -> FSPReturnDelegateComponent(result[0], returnValue)
        else -> FSP
    }

}

@Suppress("INAPPLICABLE_JVM_NAME")
@JvmName("fspnewu")
fun <Type> fspnew(constructor: context(FSPComponentListConstructDispatcher<Type>) () -> Unit): FSPComponent<Type, Unit> {
    return fspnew<Type, Unit> {
        constructor(getThis())
        FSPUnit
    }
}

context(Dispatcher)
@Suppress("NOTHING_TO_INLINE")
private inline fun <Dispatcher> Dispatcher.getThis() = this