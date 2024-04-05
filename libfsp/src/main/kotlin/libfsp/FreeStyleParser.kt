package libfsp

import libfsp.components.*
import libfsp.reference.FSPReferenceAccessDispatcher
import java.util.*
import kotlin.collections.ArrayList

class FreeStyleParser<Type, Return>(private val entity: FSPEntity<Type, Return>) {
    fun execute(input: Array<out Type>) = execute(input.asList())
    fun execute(input: ArrayList<Type>) = execute(input as List<Type>)

    private fun execute(input: List<Type>): Return {
        val referenceAccessDispatcher = FSPReferenceAccessDispatcher(UUID.randomUUID())

        val analyzeDispatcher = FSPEntityExecuteDispatcher(input, 0, referenceAccessDispatcher)
        return entity.execute(analyzeDispatcher)
    }
}
