package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatchReceiver
import libfsp.reference.FSPValue

open class Type private constructor() {
    companion object: FSPTypedPattern<Char, Type>() {
        override fun FSPPatternInitializeDispatchReceiver<Char>.initialize(): FSPValue<Type> {
            TODO("Not yet implemented")
        }
    }
    object Void: Type()
}