package libfsp.components

import libfsp.reference.FSPValue

internal class FSPReturnDelegateComponent<Type, Return>(
    private val component: FSPComponent<Type, *>,
    private val returnValue: FSPValue<Return>
): FSPComponent<Type, Return>() {
    override fun FSPEntityExecuteDispatcher<Type>.run(): Return {
        with(component) { run() }
        return referenceAccessDispatcher.get(returnValue)
    }
}