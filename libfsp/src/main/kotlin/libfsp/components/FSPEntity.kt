package libfsp.components

import libfsp.reference.FSPReferenceDispatcher

data class FSPEntity<Type, Return> internal constructor(
    internal val component: FSPComponent<Type, Return>,
    internal val lazyErrorMessage: (context(FSPReferenceDispatcher) () -> String)?
)