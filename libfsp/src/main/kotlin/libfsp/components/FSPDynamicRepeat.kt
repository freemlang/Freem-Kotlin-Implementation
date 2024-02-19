package libfsp.components

data class FSPDynamicRepeat<Type, Return> internal constructor(
    internal val min: Int?,
    internal val max: Int?,
    override val component: FSPComponent<Type, Return>,
    internal val kind: FSPDynamicRepeatKind
): FSPRepeat<Type, Return>() {
    init {
        if (min != null) {
            check(min > 0) { "min must be greater than 0" }
            if (max != null) check(min <= max) { "max must be greater than min" }
        }
    }
}

internal enum class FSPDynamicRepeatKind {
    LAZY,
    GREEDY
}