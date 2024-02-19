package libfsp.components

class FSPOptional<Type, Return> internal constructor(component: FSPComponent<Type, Return>): FSPComponent<Type, Return?> {
    internal val component: FSPComponent<Type, Return> =
        if (component is FSPOptional<Type, *>)
            @Suppress("UNCHECKED_CAST")
            component.component as FSPComponent<Type, Return>
        else component
}