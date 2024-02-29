package libfsp.components

import libfsp.reference.FSPValue

internal class FSPReturnDelegateComponent<Type, Return>(
    private val component: FSPComponent<Type, *>,
    private val returnValue: FSPValue<Return>
): FSPComponent<Type, Return>() {
    override fun FSPComponentDispatcher<Type>.run(): FSPValue<Return> {
        with(component) { run() }
        return returnValue
    }
}