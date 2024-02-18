package libfsp

import libfsp.components.*

class FSPPatternExecutionSystem<Type, Return>(pattern: FSPPattern<Type, *, Return>) {
    private val component: FSPComponent<Type, *> = fixComponent(pattern)

    private fun <Type> fixComponent(component: FSPComponent<Type, *>): FSPComponent<Type, *> {
        return when (component) {
            is FSPConstant, is FSPJudgement<*>, is FSPTask -> component
            is FSPOptional -> {
                var releasedOptional: FSPOptional<Type, *> = component
                while (releasedOptional.component is FSPOptional<Type, *>) releasedOptional = releasedOptional.component as FSPOptional<Type, *>
                releasedOptional
            }
            is FSPGroup -> when (component.components.size) {
                1 -> fixComponent(component.components[0])
                else -> {
                    TODO()
                }
            }
            is FSPTypedPattern -> when (component.components.size) {
                1 -> fixComponent(component.components[0])
                else -> {
                    TODO()
                }
            }
            is FSPUnitPattern -> when (component.components.size) {
                1 -> fixComponent(component.components[0])
                else -> {
                    TODO()
                }
            }
            is FSPGreedyRepeat<Type, *, *> ->
                FSPGreedyRepeat(
                    component.min,
                    component.max,
                    fixComponent(@Suppress("UNCHECKED_CAST") (component.component as FSPComponent<Type, *>))
                )
            is FSPLazyRepeat<Type, *, *> ->
                FSPLazyRepeat(
                    component.min,
                    component.max,
                    fixComponent(@Suppress("UNCHECKED_CAST") (component.component as FSPComponent<Type, *>))
                )
            is FSPStaticRepeat<Type, *, *> ->
                FSPStaticRepeat(
                    component.times,
                    fixComponent(@Suppress("UNCHECKED_CAST") (component.component as FSPComponent<Type, *>))
                )
            is FSPSwitch -> TODO()
            is FSPTypedSwitch -> TODO()
        }
    }

    fun execute(input: List<Type>): Return {
        var componentIndex = 0
        var inputIndex = 0
        while (componentIndex < components.size) {

        }



        @Suppress("UNCHECKED_CAST")
        return when (pattern) {
            is FSPUnitPattern -> Unit
            is FSPTypedPattern<*, *> -> pattern.returnReference.value
        } as Return
    }
}
