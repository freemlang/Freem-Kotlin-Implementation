package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField
import org.freem.compiler.frontend.Promise

class Constructor {
    companion object: Partition<Constructor> {
        override fun PartitionField.initialize(): Promise<Constructor> {
            add partition AccessModifier
            add partition ` `
            add static "constructor"
            add partition ` ?`
            add partition Factor
            add partition ` ?`
            add partition CodeBlock
        }
    }
}