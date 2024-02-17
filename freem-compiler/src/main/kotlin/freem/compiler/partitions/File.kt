package freem.compiler.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue

class File private constructor(
    val `package`: Package,
    val imports: List<Package>,
    val functions: List<Function>,
    val classes: List<Class>
) {
    companion object: Partition<File>() {
        override fun PartitionField.initialize(): PartitionValue<File> {

            add partition `|?`

            add static "package"
            add partition ` `
            val `package` by add partition Package

            add partition `|`

            add static "import"
            add partition ` `
            val imports by add partition Package repeatMin 0

            add partition `|`

            val classes = newValue { mutableListOf<Class>() }
            val functions = newValue { mutableListOf<Function>() }

            add field {
                add switch {
                    case field {
                        val `class` by add partition Class
                        add task { classes.get().add(`class`.get()) }
                    }
                    case field {
                        val function by add partition Function
                        add task { functions.get().add(function.get()) }
                    }
                }
                add partition `|?`
            }

            return newValue {
                File(
                    `package` = `package`.get(),
                    imports = imports.get(),
                    functions = functions.get(),
                    classes = classes.get()
                )
            }
        }
    }
}
