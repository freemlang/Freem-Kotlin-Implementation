package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatchReceiver
import libfsp.reference.FSPValue

class CodeBlock {
    companion object: FSPTypedPattern<Char, CodeBlock>() {
        override fun FSPPatternInitializeDispatchReceiver<Char>.initialize(): FSPValue<CodeBlock> {
            next = const('{')
            next = const('}')

            return value { CodeBlock() }
        }
    }
}