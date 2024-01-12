package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField
import org.freem.compiler.frontend.Promise

class Identifier private constructor(val value: String) {
    companion object: Partition<Identifier> {
        override fun PartitionField.initialize(): Promise<Identifier> {
            val letter = { char: Char -> char in 'a'..'z' || char in 'A'..'Z' }

            val name = newCapture()

            add custom letter
            add custom { letter(it) || it.isDigit() } repeatMin 0

            name.fin()

            return Promise { Identifier(name.get()) }
        }
    }
}