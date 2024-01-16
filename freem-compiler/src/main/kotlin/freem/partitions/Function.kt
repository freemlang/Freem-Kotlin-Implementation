package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue

class Function private constructor(val name: Identifier, val returnType: Type) {
    companion object: Partition<Function>() {
        override fun PartitionField.initialize(): PartitionValue<Function> {
            add partition AccessModifier
            add partition ` `
            add switch {
                case static "infix"
                case static "inline"
            } optional true
            add partition ` `
            add static "func"
            add switch {
                case partition ` `
                case field {
                    add partition ` ?`
                    // TODO: add partition Generic
                    add partition ` ?`
                }
            }
            val name by add partition Identifier
            add partition ` ?`
            add partition Factor
            add partition ` ?`
            val type = newValue<Type>()
            add.field {
                add static ':'
                add partition ` ?`
                add partition Type by type
                add partition ` ?`
            } optional true
            add partition CodeBlock

            return newValue { Function(name.get(), type.get()) }
        }
    }
}