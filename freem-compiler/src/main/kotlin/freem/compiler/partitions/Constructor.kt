package freem.compiler.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.PartitionAnalyzer
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

class Constructor {
    companion object: Partition<Constructor>() {
        override fun PartitionField.initialize(): PartitionValue<Constructor> {
            add partition AccessModifier
            add partition ` `
            add static "constructor"
            add partition ` ?`
            add partition Factor
            add partition ` ?`
            add partition CodeBlock

            return newValue { Constructor() }
        }
    }
}