package json

import libfsp.components.FSPTypedComponent
import libfsp.components.contexts.FSPEntityConstructDispatcher
import libfsp.components.contexts.asString
import libfsp.reference.FSPValue

class JSONString private constructor(internal val string: String): JSONValue {
    companion object: FSPTypedComponent<Char, JSONString>() {
        override fun FSPEntityConstructDispatcher<Char>.initialize(): FSPValue<JSONString> {
            '"'.queue()
            val charList by switch<Char> {
                judge { it != '\n' && it != '\\' }.autoQueue()
                group<Char> {
                    '\\'.queue()
                    val char by switch<Char> {
                        '"'.autoQueue()
                        '\\'.autoQueue()
                        '/'.autoQueue()
                        'b'.queue { '\b' }
                        'f'.queue { '\u000c' }
                        'n'.queue { '\n' }
                        'r'.queue { '\r' }
                        't'.queue { '\t' }
                        group<Char> {
                            'u'.queue()
                            val code by judge { it in '0'..'9' || it in 'a'..'f' || it in 'A'..'F' }.repeat(4).queue().asString
                            value { Char(code.value.toInt(16)) }
                        }.autoQueue()
                    }.queue()
                    char
                }.autoQueue()
            }.lazyRepeat(0, null).queue()
            '"'.queue()
            return value { JSONString(charList.value.joinToString("")) }
        }
    }
}