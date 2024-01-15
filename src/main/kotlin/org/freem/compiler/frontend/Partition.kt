package org.freem.compiler.frontend

import org.freem.compiler.frontend.field.PartitionField
import java.util.concurrent.Future

abstract class Partition<Return> {
    init {

    }
    abstract fun PartitionField.initialize(): Future<Return>
}
