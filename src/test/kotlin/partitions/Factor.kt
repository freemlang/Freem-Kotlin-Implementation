package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.field.PartitionField
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

class Factor {
    companion object: Partition<Factor>() {
        override fun PartitionField.initialize(): Future<Factor> {
            add static '('
            add static ')'

            return FutureTask { Factor() }
        }
    }
}