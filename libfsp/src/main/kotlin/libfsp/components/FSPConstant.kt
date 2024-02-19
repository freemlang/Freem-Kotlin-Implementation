package libfsp.components

data class FSPConstant<Type> internal constructor(internal val content: List<Type>): FSPComponent<Type, List<Type>> {
    init {
        check(content.isNotEmpty()) { "value is empty" }
    }

    companion object {
        fun <Type> combineConsecutiveConstants(components: List<FSPComponent<Type, *>>): List<FSPComponent<Type, *>> {
            val componentBuffer = mutableListOf<FSPComponent<Type, *>>()
            if (components.isEmpty()) throw IllegalStateException("group is empty")
            else if (components.size > 1) {
                val constBuffer = mutableListOf<Type>()
                fun uploadBuffer() {
                    if (constBuffer.isNotEmpty()) {
                        componentBuffer.add(FSPConstant(constBuffer.toList()))
                        constBuffer.clear()
                    }
                }
                for (component in components) {
                    if (component is FSPConstant) {
                        constBuffer.addAll(component.content)
                        continue
                    }
                    uploadBuffer()
                    componentBuffer.add(component)
                }
                uploadBuffer()
            }
            val result = componentBuffer.toList()
            componentBuffer.clear()
            return result
        }
    }
}