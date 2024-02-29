package libfsp.components

import libfsp.reference.FSPReferenceDispatcher
import java.util.*

internal interface FSPTask<Type, Return>: FSPComponent<Type, Return> {
    fun run(uuid: UUID, referenceDispatcher: FSPReferenceDispatcher)
}