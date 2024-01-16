package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import java.util.concurrent.Future

enum class AccessModifier {
    PUBLIC,
    PRIVATE,
    PROTECTED,
    INTERNAL
    ;
    companion object: Partition<AccessModifier>() {
        override fun PartitionField.initialize(): Future<AccessModifier> {
            val modifier by add.switch<AccessModifier> {
                case returns PUBLIC      static "public"
                case returns PRIVATE     static "private"
                case returns PROTECTED   static "protected"
                case returns INTERNAL    static "internal"
            }

            return modifier
        }
    }
}
