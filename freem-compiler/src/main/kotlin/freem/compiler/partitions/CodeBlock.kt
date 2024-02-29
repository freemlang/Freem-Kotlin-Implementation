package freem.compiler.partitions

import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue

class CodeBlock {
    companion object: FSPTypedComponent<Char, CodeBlock>() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize(): FSPValue<CodeBlock> {
            '{'.queue()
            '}'.queue()

            return value { CodeBlock() }
        }
    }
}