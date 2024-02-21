package json

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.reference.FSPValue

data class JSONArray(internal val array: Array<JSONData>): JSONData {
    companion object: FSPTypedPattern<Char, JSONArray>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<JSONArray> {
            val buffer = value { mutableListOf<JSONData>() }
            queue = const('[')
            space
            val firstItem: FSPValue<JSONData?>
            queue = JSONData.optional().also { firstItem = it.fspvalue }
            task {
                if (firstItem.value != null) {
                    buffer.value.add(firstItem.value!!)
                }
            }
            queue = group {
                queue = const(',')
                space
                val item: FSPValue<JSONData?>
                queue = JSONData.also { item = it.fspvalue }
                task {
                    if (item.value != null) {
                        buffer.value.add(item.value!!)
                    }
                }
                space
            }.greedyRepeat(0, null)
            queue = group {
                queue = const(',')
                space
            }.optional()
            queue = const(']')
            return value {
                val array = buffer.value.toTypedArray()
                buffer.value.clear()
                return@value JSONArray(array)
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JSONArray

        return array.contentEquals(other.array)
    }

    override fun hashCode(): Int {
        return array.contentHashCode()
    }
}