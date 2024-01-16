package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

class Identifier private constructor(val value: String) {
    companion object: Partition<Identifier>() {
        override fun PartitionField.initialize(): PartitionValue<Identifier> {
            val letter = { char: Char -> char in 'a'..'z' || char in 'A'..'Z' }

            val name = newCapture()

            add custom letter
            add custom { letter(it) || it.isDigit() } repeatMin 0

            name.fin()

            return newValue { Identifier(name.get()) }
        }
    }
}