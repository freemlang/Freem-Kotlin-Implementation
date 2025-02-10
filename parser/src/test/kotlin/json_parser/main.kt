package json_parser

import java.io.IOException
import java.io.InputStreamReader

fun main() {
    val path = "json_parser/sample.json"
    val charset = Charsets.UTF_8
    val bufferSize = DEFAULT_BUFFER_SIZE

    val stream =
        ClassLoader.getSystemResourceAsStream(path)
            ?: throw IOException("Unable to find resource at $path")
    val reader = InputStreamReader(stream.buffered(bufferSize), charset)
    val iterator =
        object : CharIterator() {
            private var current: Int = reader.read()

            override fun nextChar(): Char {
                val char = Char(current)
                current = reader.read()
                return char
            }

            override fun hasNext(): Boolean {
                return current != -1
            }
        }
    val string = StringBuilder()
    while (iterator.hasNext()) string.append(iterator.nextChar())
    println(string)
}
