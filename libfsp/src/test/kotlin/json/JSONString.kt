package json

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.components.contexts.asString
import libfsp.reference.FSPValue

class JSONString: JSONValue {
    companion object: FSPTypedPattern<Char, JSONString>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<JSONString> {
            '"'.queue()
            switch<Char> {
                judge { it != '\n' && it != '\\' }.queue()
                group<Char> {
                    '\\'.queue()
                    val char by switch<Char> {
                        '"'.queue()
                        '\\'.queue()
                        '/'.queue()
                        'b'.queue { '\b' }
                        'f'.queue { '\u000c' }
                        'n'.queue { '\n' }
                        'r'.queue { '\r' }
                        't'.queue { '\t' }
                        group<Char> {
                            'u'.queue()
                            val code by judge { it in '0'..'9' || it in 'a'..'f' || it in 'A'..'F' }.repeat(4).queue().asString
                            value { Char(code.value.toInt(16)) }
                        }.queue()
                    }.queue()
                    char
                }.queue()
            }.lazyRepeat(0, null).queue()
            '"'.queue()
            return value {
                JSONString()
            }
        }
    }
}