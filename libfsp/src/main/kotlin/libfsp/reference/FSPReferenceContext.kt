package libfsp.reference

class FSPReferenceContext internal constructor() {
    val <Type> FSPValue<Type>.value: Type
        get() = TODO()

    var <Type> FSPVariance<Type>.value: Type
        get() = TODO()
        set(value) { TODO() }
}