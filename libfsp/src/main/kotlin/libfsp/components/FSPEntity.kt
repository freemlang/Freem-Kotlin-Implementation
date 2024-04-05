package libfsp.components

import libfsp.reference.FSPReferenceAccessDispatcher
import java.util.UUID

class FSPEntity<Type, Return> internal constructor(
    private val component: FSPComponent<Type, Return>,
    private val errorMessage: (context(FSPReferenceAccessDispatcher) () -> String)?
) {
    internal val uuid: UUID = UUID.randomUUID()
    internal fun execute(dispatcher: FSPEntityExecuteDispatcher<Type>): Return {
        try {
            with(component) {
                dispatcher.run()
            }
        } catch (invalid: FSPInvalidInputException) {
            throw FSPInvalidInputException(invalid.index, errorMessage?.invoke(dispatcher.referenceAccessDispatcher), invalid.cause)
        }
    }
}