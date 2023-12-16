import org.freem.compiler.frontend.PP

fun main() {
    var capturedStr = ""

    PP<Char> {
        capturedStr = capture {
            scope {
                while (hasNext()) if (!next().isDigit()) break
            }
        }.joinToString("")
    }.run("43213".toList().toTypedArray())

    println(capturedStr)
}
