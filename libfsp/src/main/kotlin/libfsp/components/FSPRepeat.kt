package libfsp.components

sealed class FSPRepeat<Type, Return>: FSPComponent<Type, List<Return>> {
    internal abstract val component: FSPComponent<Type, Return>
}