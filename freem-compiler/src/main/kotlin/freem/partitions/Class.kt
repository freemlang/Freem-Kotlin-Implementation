package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

class Class private constructor(
    val name: Identifier,
    val modifier: AccessModifier,
    val factor: Factor,
) {
    companion object: Partition<Class>() {
        override fun PartitionField.initialize(): PartitionValue<Class> {
            val modifier by add partition AccessModifier
            add partition ` `
            add static "class"
            add partition ` `
            val name by add partition Identifier
            add partition ` ?`
            val factor by add partition Factor

            add static '{'



            add static '}'

            return newValue {
                Class(
                    name.get(),
                    modifier.get(),
                    factor.get(),
                )
            }
        }
    }
}