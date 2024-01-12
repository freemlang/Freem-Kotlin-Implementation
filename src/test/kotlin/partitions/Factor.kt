package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField
import org.freem.compiler.frontend.Promise

class Factor {
    companion object: Partition<Factor> {
        override fun PartitionField.initialize(): Promise<Factor> {
            add static '('
            add static ')'

            return Promise { Factor() }
        }
    }
}