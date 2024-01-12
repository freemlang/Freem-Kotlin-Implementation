package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField
import org.freem.compiler.frontend.Promise

enum class AccessModifier {
    PUBLIC, PRIVATE, PROTECTED, INTERNAL;

    companion object: Partition<AccessModifier> {
        override fun PartitionField.initialize(): Promise<AccessModifier> {
            val modifier by add.case<AccessModifier> {
                case returns PUBLIC      static "public"
                case returns PRIVATE     static "private"
                case returns PROTECTED   static "protected"
                case returns INTERNAL    static "internal"
            }

            return modifier
        }
    }
}
