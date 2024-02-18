package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternContext
import libfsp.reference.FSPValue

class CodeBlock {
    companion object: FSPTypedPattern<Char, CodeBlock>() {
        override fun FSPPatternContext<Char>.initialize(): FSPValue<CodeBlock> {
            next = const('{')
            next = const('}')

            return value { CodeBlock() }
        }
    }
}