import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField

fun main() {

}

object TestNameSpace {
    class File private constructor(
        val name: String,
        val package_: Package,
        val imports: List<Package>,
    ) {
        companion object: Partition<File> {
            override fun PartitionField.execute(): File {
                TODO("Not yet implemented")
            }
        }
    }

    class Package private constructor(

    ) {
        companion object: Partition<Package> {
            override fun PartitionField.execute(): Package {
                TODO("Not yet implemented")
            }
        }
    }

    class Identifier private constructor(val value: String) {


        companion object: Partition<Identifier> {
            override fun PartitionField.execute(): Identifier {
                return Identifier("")
            }
        }
    }

    class Class private constructor(val name: String) {


        companion object: Partition<Class> {
            override fun PartitionField.execute(): Class {
                TODO("Not yet implemented")
            }
        }
    }

    class Function private constructor(val name: String, val returnType: Type) {


        companion object: Partition<Function> {
            override fun PartitionField.execute(): Function {
                TODO("Not yet implemented")
            }
        }
    }

    class Type private constructor() {


        companion object: Partition<Type> {
            override fun PartitionField.execute(): Type {
                TODO("Not yet implemented")
            }
        }
    }

    class Expression private constructor() {


        companion object: Partition<Expression> {
            override fun PartitionField.execute(): Expression {
                TODO("Not yet implemented")
            }
        }
    }
}