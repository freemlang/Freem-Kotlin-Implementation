package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.reference.FSPValue

open class Type private constructor() {
    companion object: FSPTypedPattern<Char, Type>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<Type> {
            TODO("Not yet implemented")
        }
    }
    object Void: Type()
}