package org.freem.compiler.frontend

import org.freem.compiler.frontend.interfaces.field.PartitionField
import org.freem.compiler.frontend.implement.field.PartitionFieldImpl
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
