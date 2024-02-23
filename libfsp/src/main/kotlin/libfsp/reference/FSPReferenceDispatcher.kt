package libfsp.reference

class FSPReferenceDispatcher internal constructor() {
    context(FSPReferenceDispatcher)
    val <Type> FSPValue<Type>.value: Type
        get() = TODO()

    context(FSPReferenceDispatcher)
    var <Type> FSPVariance<Type>.value: Type
        get() = TODO()
        set(value) { TODO() }
}
