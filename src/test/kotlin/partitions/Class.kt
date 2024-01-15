package partitions

import org.freem.compiler.partition.Partition
import org.freem.compiler.partition.interfaces.field.PartitionField
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

class Class private constructor(
    val name: Identifier,
    val modifier: AccessModifier,
    val factor: Factor,
) {
    companion object: Partition<Class>() {
        override fun PartitionField.initialize(): Future<Class> {
            val modifier by add partition AccessModifier
            add partition ` `
            add static "class"
            add partition ` `
            val name by add partition Identifier
            add partition ` ?`
            val factor by add partition Factor

            add static '{'



            add static '}'

            return FutureTask {
                Class(
                    name.get(),
                    modifier.get(),
                    factor.get(),
                )
            }
        }
    }
}