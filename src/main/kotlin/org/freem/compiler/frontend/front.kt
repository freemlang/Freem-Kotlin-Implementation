package org.freem.compiler.frontend

interface Partition<Return> {
    fun PartitionField.execute(): Return
}

sealed interface PartitionField

