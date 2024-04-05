package libfsp.components

import libfsp.reference.FSPReferenceAccessDispatcher
import java.util.UUID

internal class FSPLambdaTask<Type, Return>(private val task: (UUID, FSPReferenceAccessDispatcher) -> Return): FSPTask<Type, Return> {
    override fun run(uuid: UUID, referenceDispatcher: FSPReferenceAccessDispatcher) {
        task(uuid, referenceDispatcher)
    }
}