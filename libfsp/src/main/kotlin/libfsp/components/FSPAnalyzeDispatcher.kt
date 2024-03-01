package libfsp.components

import libfsp.reference.FSPReferenceDispatcher
import java.util.UUID

internal class FSPAnalyzeDispatcher<out Type>(
    val input: List<Type>,
    var index: Int,
    val lazyErrorMessage: (context(FSPReferenceDispatcher) () -> String)?,
    val uuid: UUID,
    val referenceDispatcher: FSPReferenceDispatcher
) {
    fun throwInvalid(): Nothing = throw FSPInvalidInputException(index, lazyErrorMessage?.invoke(referenceDispatcher), null)
}