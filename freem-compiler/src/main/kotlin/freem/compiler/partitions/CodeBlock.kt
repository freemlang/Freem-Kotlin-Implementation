package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue

class CodeBlock {
    companion object: FSPTypedPattern<Char, CodeBlock>() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize(): FSPValue<CodeBlock> {
            '{'.queue()
            '}'.queue()

            return value { CodeBlock() }
        }
    }
}