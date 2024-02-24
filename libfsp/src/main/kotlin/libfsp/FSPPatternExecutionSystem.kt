package libfsp

import libfsp.components.*
import libfsp.reference.FSPReferenceDispatcher
import java.util.UUID

class FSPPatternExecutionSystem<Type, Return>(pattern: FSPPattern<Type, *, Return>) {
    fun execute(input: List<Type>): Return {
        val referenceDispatcher = FSPReferenceDispatcher(UUID.randomUUID())

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
