import libfsp.reference.ValueReference
import libfsp.reference.VarianceReference
import libfsp.reference.ReferenceAccessibleScope
import java.util.UUID

fun main() {
    val uuid = UUID.randomUUID()
    val scope = ReferenceAccessibleScope(uuid)

    val imutRef = ValueReference<String>()
    val mutRef = VarianceReference<Int>()

    imutRef.alloc(uuid) { "Hello, World!" }
    mutRef.alloc(uuid) { 10 }

    with(scope) {
        val imutValue by imutRef
        println(imutValue)
        println(imutRef())

        var mutValue by mutRef
        println(mutValue)
        println(mutRef())
        mutValue = 20
        println(mutValue)
        println(mutRef())
    }

    imutRef.free(uuid)
    mutRef.free(uuid)

    with(scope) {
        imutRef()
        mutRef()
    }
}