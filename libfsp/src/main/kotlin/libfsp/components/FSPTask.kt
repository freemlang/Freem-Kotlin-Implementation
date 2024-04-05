package libfsp.components

import libfsp.reference.FSPReferenceAccessDispatcher
import java.util.*

internal interface FSPTask<Type, Return>: FSPComponent<Type, Return>() {
    fun run(uuid: UUID, referenceDispatcher: FSPReferenceAccessDispatcher)
}