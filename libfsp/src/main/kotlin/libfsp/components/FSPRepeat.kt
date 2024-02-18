package libfsp.components

sealed class FSPRepeat<Type>: FSPComponent<Type> {
    internal abstract val component: FSPComponent<Type>
}