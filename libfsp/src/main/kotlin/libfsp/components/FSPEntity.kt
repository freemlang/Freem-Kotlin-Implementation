package libfsp.components

import libfsp.reference.FSPReferenceDispatcher
import java.util.UUID

data class FSPEntity<Type, Return> internal constructor(
    internal val component: FSPComponent<Type, Return>,
    internal val lazyErrorMessage: (context(FSPReferenceDispatcher) () -> String)?
) {
    internal val uuid: UUID = UUID.randomUUID()
}