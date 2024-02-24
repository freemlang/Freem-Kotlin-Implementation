package libfsp.components

import libfsp.reference.FSPReferenceDispatcher

internal interface FSPTask<Type>: FSPComponent<Type, Nothing> {
    fun run(referenceDispatcher: FSPReferenceDispatcher)
}