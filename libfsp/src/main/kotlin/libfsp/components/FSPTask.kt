package libfsp.components

import libfsp.reference.FSPReferenceContext

data class FSPTask<Type> internal constructor(internal val task: FSPReferenceContext.() -> Unit): FSPComponent<Type, Nothing>