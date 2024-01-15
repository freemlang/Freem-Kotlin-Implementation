package org.freem.compiler.partition

import org.freem.compiler.partition.interfaces.field.PartitionField
import org.freem.compiler.partition.implement.field.PartitionFieldImpl
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
