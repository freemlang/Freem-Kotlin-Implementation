package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.reference.FSPValue

class CodeBlock {
    companion object: FSPTypedPattern<Char, CodeBlock>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<CodeBlock> {
            '{'.queue()
            '}'.queue()

            return value { CodeBlock() }
        }
    }
}