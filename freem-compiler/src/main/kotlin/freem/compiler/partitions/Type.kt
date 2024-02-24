package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue

open class Type private constructor() {
    companion object: FSPTypedPattern<Char, Type>() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize(): FSPValue<Type> {
            TODO("Not yet implemented")
        }
    }
    object Void: Type()
}