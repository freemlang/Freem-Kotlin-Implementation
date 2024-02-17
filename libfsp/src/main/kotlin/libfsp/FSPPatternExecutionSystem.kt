package libfsp

import libfsp.components.FSPPattern
import libfsp.components.FSPTypedPattern
import libfsp.components.FSPVoidPattern

class FSPPatternExecutionSystem<Type, Return>(private val pattern: FSPPattern<Type, *>) {
    fun execute(vararg input: Type): Return {
        val components = pattern.components
        var componentIndex = 0
        var inputIndex = 0
        while (componentIndex < components.size) {

        }

        @Suppress("UNCHECKED_CAST")
        return when (pattern) {
            is FSPVoidPattern -> Unit
            is FSPTypedPattern<*, *> -> pattern.returnReference.value
        } as Return
    }
}
