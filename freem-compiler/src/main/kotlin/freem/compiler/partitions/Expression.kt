package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeContext
import libfsp.reference.FSPValue

class Expression private constructor() {
    companion object: FSPTypedPattern<Char, Expression>() {
        override fun FSPPatternInitializeContext<Char>.initialize(): FSPValue<Expression> {
            TODO("Not yet implemented")
        }
    }
}