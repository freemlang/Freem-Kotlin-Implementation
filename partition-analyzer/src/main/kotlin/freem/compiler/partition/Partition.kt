package freem.compiler.partition

import freem.compiler.partition.implement.field.PartitionFieldImpl
import freem.compiler.partition.interfaces.field.PartitionField
import java.util.concurrent.Future

abstract class Partition<ReturnType> {
    init {
        val field = PartitionFieldImpl()
        with(field) {
            initialize()
        }
    }
    abstract fun PartitionField.initialize(): Future<ReturnType>
}
