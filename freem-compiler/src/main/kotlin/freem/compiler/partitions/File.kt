package freem.compiler.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue

class File private constructor(
    val `package`: Package,
    val imports: List<Package>,
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



            return newValue {
                File(
                    `package` = `package`.get(),
                    imports = imports.get()
                )
            }
        }
    }
}
