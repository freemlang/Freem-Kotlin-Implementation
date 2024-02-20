package libfsp.components

import freem.utilities.collections.trie.toTrie
import freem.utilities.collections.trie.trieOf

class FSPSwitch<Type> internal constructor(components: List<FSPComponent<Type, *>>): FSPComponent<Type, List<Type>> {
    internal val components: List<FSPComponent<Type, *>>

    init {
        val resultComponents: MutableList<FSPComponent<Type, *>> = mutableListOf()
        val consecutiveComponentBuffer: MutableList<FSPComponent<Type, *>> = mutableListOf()
        var beforeComponentClass: Class<*>? = null
        for (component in components) {
            val currentComponentClass = component::class.java
            if (currentComponentClass != beforeComponentClass) {
                when (consecutiveComponentBuffer.size) {
                    0 -> {}
                    1 -> resultComponents.add(consecutiveComponentBuffer[0])
                    else -> when (consecutiveComponentBuffer[0]) {
                        is FSPConstant -> {
                            @Suppress("UNCHECKED_CAST") (consecutiveComponentBuffer as List<FSPConstant<Type>>)
                            val trie = consecutiveComponentBuffer.map { it.content }.toTrie()

                        }
                        is FSPGroup -> TODO()
                        is FSPJudgement<*> -> TODO()
                        is FSPOptional -> TODO()
                        is FSPTypedPattern -> TODO()
                        is FSPUnitPattern -> TODO()
                        is FSPDynamicRepeat<*, *> -> TODO()
                        is FSPStaticRepeat<*, *> -> TODO()
                        is FSPSwitch -> TODO()
                        is FSPLambdaTask -> TODO()
                        is FSPTypedSwitch -> TODO()
                    }
                }
                consecutiveComponentBuffer.clear()
            }
            consecutiveComponentBuffer.add(component)
            beforeComponentClass = currentComponentClass
        }
        this.components = resultComponents
        resultComponents.clear()
    }
}