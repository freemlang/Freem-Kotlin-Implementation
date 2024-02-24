package libfsp.components

import libfsp.reference.FSPReferenceDispatcher

internal class FSPLambdaTask<Type>(private val task: (FSPReferenceDispatcher) -> Unit): FSPTask<Type> {
    override fun run(referenceDispatcher: FSPReferenceDispatcher) = task(referenceDispatcher)
}