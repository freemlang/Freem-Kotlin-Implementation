package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField
import org.freem.compiler.frontend.Promise

class Class private constructor(
    val name: Identifier,
    val modifier: AccessModifier,
    val factor: Factor,
) {
    companion object: Partition<Class> {
        override fun PartitionField.initialize(): Promise<Class> {

            val modifier by add partition AccessModifier
            add partition ` `
            add static "class"
            add partition ` `
            val name by add partition Identifier
            add partition ` ?`
            val factor by add partition Factor

            add static '{'



            add static '}'

            return Promise {
                Class(
                    name.get(),
                    modifier.get(),
                    factor.get(),
                )
            }
        }
    }
}