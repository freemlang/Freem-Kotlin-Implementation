package org.freem.compiler.frontend.partition

class PartitionInterruptedException(
    message: String? = null,
    val partition: Partition<*>
): Exception(message)