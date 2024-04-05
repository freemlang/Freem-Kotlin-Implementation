package libfsp.components

import libfsp.reference.FSPReferenceAccessDispatcher

internal class FSPEntityExecuteDispatcher<out Type>(
    val input: List<Type>,
    var index: Int,
    val referenceAccessDispatcher: FSPReferenceAccessDispatcher
) {
    fun throwInvalid(): Nothing = throw FSPInvalidInputException(index, null, null)
}