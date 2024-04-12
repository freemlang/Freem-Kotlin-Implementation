package libfsp.components

import libfsp.reference.FSPValue

sealed class FSPComponent<out Type, Return> {
    internal abstract fun FSPEntityExecuteDispatcher<@UnsafeVariance Type>.run(): Return

    internal companion object {
        operator fun <Type, Return> invoke(entities: List<FSPEntity<Type, *>>, returnValue: FSPValue<Return>): FSPComponent<Type, Return> {
            return FSPGroup(entities, returnValue)
        }

        operator fun <Type> invoke(content: List<Type>): FSPComponent<Type, List<Type>> {
            return FSPConstant(content)
        }
    }
}

private data class FSPConstant<Type>(private val content: List<Type>): FSPComponent<Type, List<Type>>() {
    override fun FSPEntityExecuteDispatcher<Type>.run(): List<Type> {
        val startIndex = index
        for (item in content) {
            if (item != input[index]) throwInvalid()
            index++
        }
        return input.subList(startIndex, index)
    }
}

private data class FSPGroup<Type, Return>(
    private val entities: List<FSPEntity<Type, *>>,
    private val returnValue: FSPValue<Return>
): FSPComponent<Type, Return>() {
    override fun FSPEntityExecuteDispatcher<Type>.run(): Return {
        for (entity in entities) entity.execute(this)
        return referenceAccessDispatcher.get(returnValue)
    }
}