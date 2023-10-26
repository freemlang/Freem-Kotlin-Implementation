package org.freem.compiler.frontend.module

import org.freem.compiler.frontend.partition.Partition
import kotlin.properties.Delegates

sealed interface Module<T> {
    val name: String
}

class MainModule<T, D>(override val name: String, private val rootPartition: Partition<T, D>) : Module<T> {
    private val partitions: MutableMap<String, Partition<T, *>> = mutableMapOf()
    val data: D by Delegates.notNull()
}

interface ExtensionModule<T, M: MainModule<T, *>>: Module<T> {
    val mainModule: M

    fun onInitialize() {}
}