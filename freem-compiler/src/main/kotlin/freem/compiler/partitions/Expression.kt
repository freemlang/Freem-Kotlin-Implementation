package freem.compiler.partitions

import libfsp.components.contexts.FSPEntityConstructDispatcher
import libfsp.reference.FSPValue

class Expression private constructor() {
    companion object: FSPTypedComponent<Char, Expression>() {
        override fun FSPEntityConstructDispatcher<Char>.initialize(): FSPValue<Expression> {
            TODO("Not yet implemented")
        }
    }
}