package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.field.PartitionField
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

class Constructor {
    companion object: Partition<Constructor>() {
        override fun PartitionField.initialize(): Future<Constructor> {
            add partition AccessModifier
            add partition ` `
            add static "constructor"
            add partition ` ?`
            add partition Factor
            add partition ` ?`
            add partition CodeBlock

            return FutureTask { Constructor() }
        }
    }
}