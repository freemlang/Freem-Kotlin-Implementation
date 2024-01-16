package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import java.util.concurrent.Future

class Function private constructor(val name: String, val returnType: Type) {
    companion object: Partition<Function>() {
        override fun PartitionField.initialize(): Future<Function> {
            TODO("Not yet implemented")
        }
    }
}