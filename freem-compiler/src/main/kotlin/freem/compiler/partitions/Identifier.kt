package freem.compiler.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue

class Identifier private constructor(val value: String) {
    companion object: Partition<Identifier>() {
        override fun PartitionField.initialize(): PartitionValue<Identifier> {
            val letter = { char: Char -> char in 'a'..'z' || char in 'A'..'Z' }

            val name = capture()

            add judge letter
            add judge { letter(it) || it.isDigit() } repeatMin 0

            name.end()

            return newValue { Identifier(name.get()) }
        }
    }
}