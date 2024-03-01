package libfsp.components

import libfsp.reference.FSPReferenceDispatcher
import libfsp.reference.FSPValue
import java.util.*

sealed class FSPComponent<out Type, Return> {
    internal abstract fun FSPAnalyzeDispatcher<@UnsafeVariance Type>.run()

    internal companion object {
        operator fun <Type, Return> invoke(entities: List<FSPEntity<Type, *>>, returnValue: FSPValue<Return>): FSPComponent<Type, Return> {
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
                else -> FSPGroup(result, returnValue)
            }
        }
    }
}

private class FSPConstant<Type>(private val content: List<Type>): FSPComponent<Type, List<Type>>() {
    override fun FSPAnalyzeDispatcher<Type>.run() {
        for (item in content) {
            if (item != input[index]) throwInvalid()
            index++
        }
    }
}