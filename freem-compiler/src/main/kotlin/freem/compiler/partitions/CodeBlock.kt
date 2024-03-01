package freem.compiler.partitions

import libfsp.components.contexts.FSPEntityConstructDispatcher
import libfsp.reference.FSPValue

class CodeBlock {
    companion object: FSPTypedComponent<Char, CodeBlock>() {
        override fun FSPEntityConstructDispatcher<Char>.initialize(): FSPValue<CodeBlock> {
            '{'.queue()
            '}'.queue()

            return value { CodeBlock() }
        }
    }
}