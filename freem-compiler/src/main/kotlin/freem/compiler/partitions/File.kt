package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.reference.FSPValue

class File private constructor(
    val `package`: Package,
    val imports: List<Package>,
    val functions: List<Function>,
    val classes: List<Class>
) {
    companion object: FSPTypedPattern<Char, File>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<File> {
            `|?`

            "package".queue()
            ` `
            val `package` by Package.queue()

            `|`

            "import".queue()
            ` `
            val imports by Package.lazyRepeat(0, null).queue()

            `|`

            val classes = value { mutableListOf<Class>() }
            val functions = value { mutableListOf<Function>() }

            group {
                switch {
                    group {
                        val `class` by Class.queue()
                        task { classes.value.add(`class`.value) }
                    }.queue()
                    group {
                        val function by Function.queue()
                        task { functions.value.add(function.value) }
                    }.queue()
                }.queue()
                `|?`
            }.queue()

            return value {
                File(
                    `package` = `package`.value,
                    imports = imports.value,
                    functions = functions.value,
                    classes = classes.value
                )
            }
        }
    }
}
