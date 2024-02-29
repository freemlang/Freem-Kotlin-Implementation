package libfsp.components

import libfsp.reference.FSPReferenceDispatcher
import java.util.UUID

internal class FSPLambdaTask<Type, Return>(private val task: (UUID, FSPReferenceDispatcher) -> Return): FSPTask<Type, Return> {
    override fun run(uuid: UUID, referenceDispatcher: FSPReferenceDispatcher) {
        task(uuid, referenceDispatcher)
    }
}