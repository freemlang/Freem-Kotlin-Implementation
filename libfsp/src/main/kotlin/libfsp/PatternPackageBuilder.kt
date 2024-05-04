package libfsp

class PatternPackageBuilder<Input>(val id: String) {
    init {
        val validation = validateID(id)
        if (validation != null) throw IllegalArgumentException(validation)
    }

    private val patterns: MutableMap<Int, Pattern<Input>> = HashMap()
    private val packages: MutableMap<Int, PatternPackage<Input>> = HashMap()

    private var builderValidation = true
    private fun builderMethod(block: () -> Unit): PatternPackageBuilder<Input> {
        if (!builderValidation) throw IllegalStateException("package has already built")
        block()
        return this
    }

    private fun validateID(id: String, paramName: String = "id"): String? {
        if (id.isEmpty()) return "$paramName cannot be empty"
        if (id.length > 32) return "$paramName cannot be greater than 32 characters"
        if (!id.matches("\\w+".toRegex())) return "$paramName only can contain A-Z, a-z, 0-9, _"
        return null
    }

    fun register(id: String, pattern: Pattern<Input>) = builderMethod {
        val validation = validateID(id)
        if (validation != null) throw IllegalArgumentException(validation)

        val idHash = id.hashCode()
        if (patterns.containsKey(idHash)) throw IllegalStateException("$id is already registered")

        patterns[idHash] = pattern
    }

    fun import(`package`: PatternPackage<Input>, alias: String? = null) = builderMethod {
        val validation = validateID(id, "alias")
        if (validation != null) throw IllegalArgumentException(validation)

        val packageId = alias ?: `package`.id
        val idHash = packageId.hashCode()
        if (packages.containsKey(idHash)) throw IllegalStateException("$packageId is already registered")

        packages[idHash] = `package`
    }

    fun build(): PatternPackage<Input> {
        val result = PatternPackage(id, patterns)
        builderValidation = false
        return result
    }
}