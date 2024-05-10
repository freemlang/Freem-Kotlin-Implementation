package libfsp

import libfsp.reference.ConstantReference
import libfsp.reference.Reference
import libfsp.reference.UnitReference
import java.util.LinkedList

abstract class Component<Input, Return> internal constructor() {
    internal abstract val returnRef: Reference<Return>
    internal abstract fun render(process: ParseProcess<Input>, trial: Int)
}

abstract class CustomComponent<Input, Return>(
    initializer: context(CustomComponentConstructionScope<Input>) () -> Reference<Return>
): Component<Input, Return>() {

    private val trialRef: ConstantReference<Int> = ConstantReference()
    final override val returnRef: Reference<Return>
    private val entities: List<Entity<Input, *>>

    init {
        val entities = LinkedList<Entity<Input, *>>()
        val scope = CustomComponentConstructionScope(trialRef, entities)
        this.returnRef = initializer(scope)
        this.entities = entities
    }

    override fun render(process: ParseProcess<Input>, trial: Int) {
        TODO("Not yet implemented")
    }
}

class CustomComponentConstructionScope<Input> internal constructor(
    private val trialRef: ConstantReference<Int>,
    private val entities: MutableList<Entity<Input, *>>
) {
    context(CustomComponentConstructionScope<Input>)
    val trial: ConstantReference<Int> get() = trialRef

    context(CustomComponentConstructionScope<Input>)
    val unit get() = UnitReference
}
