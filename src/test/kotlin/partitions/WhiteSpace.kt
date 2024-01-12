package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField
import org.freem.compiler.frontend.Promise

val ` ` = WhiteSpace
val ` ?` = WhiteSpaceAble

object WhiteSpace: Partition<Unit> {
    override fun PartitionField.initialize(): Promise<Unit> {
        add case {
            add custom Char::isWhitespace repeatMin 1
            add partition Comment
        }

        return Promise{}
    }
}

object WhiteSpaceAble: Partition<Unit> {
    override fun PartitionField.initialize(): Promise<Unit> {
        add partition WhiteSpace optional true

        return Promise{}
    }
}