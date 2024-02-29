package libfsp.components

import libfsp.reference.FSPValue

sealed class FSPComponent<out Type, Return> {
    internal abstract fun FSPComponentDispatcher<@UnsafeVariance Type>.run(): FSPValue<Return>
}

private class FSPGroup<Type, Return>(
    val components: List<FSPComponent<Type, *>>,
    val returnValue: FSPValue<Return>
): FSPComponent<Type, Return>() {


    override fun FSPComponentDispatcher<Type>.run(): FSPValue<Return> {
        TODO("Not yet implemented")
    }
}