package libfsp

import libfsp.components.FSPPattern
import libfsp.components.FSPTypedPattern
import libfsp.components.FSPUnitPattern

class FSPPatternExecutionSystem<Type, Return>(private val pattern: FSPPattern<Type, *, Return>) {
    fun execute(input: List<Type>): Return {
        val components = pattern.components
        var componentIndex = 0
        var inputIndex = 0
        while (componentIndex < components.size) {

        }



        @Suppress("UNCHECKED_CAST")
        return when (pattern) {
            is FSPUnitPattern -> Unit
            is FSPTypedPattern<*, *> -> pattern.returnReference.value
        } as Return
    }
}
