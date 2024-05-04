package libfsp

/**
 * @param id ID(name) of the package.
 *
 * Cannot be empty or greater than 32 characters.
 *
 * Only can contain A-Z, a-z, 0-9, _.
 */
class PatternPackage<Input>
internal constructor(
    val id: String,
    private val patterns: Map<Int, Pattern<Input>>
) {
    operator fun get(id: String): Pattern<Input>? {
        return patterns[id.hashCode()]
    }
    operator fun get(idHash: Int): Pattern<Input>? {
        return patterns[idHash]
    }
}