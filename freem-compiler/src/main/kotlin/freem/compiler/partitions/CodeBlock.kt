package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeContext
import libfsp.reference.FSPValue

class CodeBlock {
    companion object: FSPTypedPattern<Char, CodeBlock>() {
        override fun FSPPatternInitializeContext<Char>.initialize(): FSPValue<CodeBlock> {
            next = const('{')
            next = const('}')

            return value { CodeBlock() }
        }
    }
}