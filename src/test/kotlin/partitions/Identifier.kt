package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.interfaces.field.PartitionField
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

class Identifier private constructor(val value: String) {
    companion object: Partition<Identifier>() {
        override fun PartitionField.initialize(): Future<Identifier> {
            val letter = { char: Char -> char in 'a'..'z' || char in 'A'..'Z' }

            val name = newCapture()

            add custom letter
            add custom { letter(it) || it.isDigit() } repeatMin 0

            name.fin()

            return FutureTask { Identifier(name.get()) }
        }
    }
}