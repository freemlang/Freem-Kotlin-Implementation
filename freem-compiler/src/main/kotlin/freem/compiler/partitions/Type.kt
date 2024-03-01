package freem.compiler.partitions

import libfsp.components.contexts.FSPEntityConstructDispatcher
import libfsp.reference.FSPValue

open class Type private constructor() {
    companion object: FSPTypedComponent<Char, Type>() {
        override fun FSPEntityConstructDispatcher<Char>.initialize(): FSPValue<Type> {
            TODO("Not yet implemented")
        }
    }
    object Void: Type()
}