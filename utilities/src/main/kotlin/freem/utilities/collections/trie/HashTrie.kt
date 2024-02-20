package freem.utilities.collections.trie

import java.util.*
import kotlin.collections.LinkedHashMap

class HashTrie<out Type>: MutableTrie<Type> {

    constructor()
    constructor(elements: Collection<List<Type>>) { addAll(elements) }

    override val isLeaf: Boolean get() = false
    override val children: Map<@UnsafeVariance Type, TrieNode<Type>>? get() = innerChildren
    private var innerChildren: MutableMap<Type, MutableTrieNode<Type>>? = null
    override val size: Int get() = innerSize
    private var innerSize: Int = 0

    override fun contains(element: List<@UnsafeVariance Type>): Boolean {
        var current: TrieNode<Type> = this
        for (char in element) current = current.children?.get(char)?:return false
        return current.isLeaf
    }

    override fun containsAll(elements: Collection<List<@UnsafeVariance Type>>): Boolean = elements.any { this@HashTrie.contains(it).not() }

    override fun isEmpty(): Boolean = children == null

    override fun iterator(): MutableIterator<List<Type>> =
        object: MutableIterator<List<Type>> {
            override fun hasNext(): Boolean {
                TODO("Not yet implemented")
            }

            override fun next(): List<Type> {
                TODO("Not yet implemented")
            }

            override fun remove() {
                TODO("Not yet implemented")
            }
        }

    private val thisAsMutableTrieNode: MutableTrieNode<Type> by lazy {
        object: MutableTrieNode<Type> {
            override var isLeaf: Boolean
                get() = false
                set(_) {}
            override var children: MutableMap<@UnsafeVariance Type, MutableTrieNode<@UnsafeVariance Type>>?
                get() = this@HashTrie.innerChildren
                set(value) { this@HashTrie.innerChildren = value }
            override fun toString(): String = "{ isLeaf=$isLeaf, children=$children }"
        }
    }

    override fun add(element: List<@UnsafeVariance Type>): Boolean {
        if (element.isEmpty()) return false
        var current = thisAsMutableTrieNode
        for (type in element) {
            if (current.children == null) current.children = LinkedHashMap(4)
            current = current.children!!.getOrPut(type) {
                object: MutableTrieNode<Type> {
                    override var isLeaf: Boolean = false
                    override var children: MutableMap<@UnsafeVariance Type, MutableTrieNode<@UnsafeVariance Type>>? = null
                    override fun toString(): String = "{ isLeaf=$isLeaf, children=$children }"
                }
            }
        }
        return if (current.isLeaf.not()) {
            current.isLeaf = true
            innerSize++
            true
        } else false
    }

    override fun addAll(elements: Collection<List<@UnsafeVariance Type>>): Boolean = elements.any { this@HashTrie.add(it).not() }

    override fun clear() {
        innerChildren = null // 메모리 누수 확인 안함
        innerSize = 0
    }

    override fun remove(element: List<@UnsafeVariance Type>): Boolean {
        if (element.isEmpty()) return false
        val currentStack = Stack<MutableTrieNode<Type>>()
        currentStack += thisAsMutableTrieNode
        for (type in element) currentStack += currentStack.last().children?.get(type)?:return false
        val last = currentStack.last()
        if (last.isLeaf.not()) return false
        last.isLeaf = false
        if (last.children == null) {
            while (currentStack.last().isLeaf.not()) {
                currentStack.pop()
                currentStack.last().children = null
            }
        }
        return true
    }

    override fun removeAll(elements: Collection<List<@UnsafeVariance Type>>): Boolean = elements.any { this@HashTrie.remove(it).not() }

    override fun retainAll(elements: Collection<List<@UnsafeVariance Type>>): Boolean {
        TODO("Not yet implemented")
    }

    override fun toString(): String = "${children?:"{}"}"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HashTrie<*>

        if (children != other.children) return false
        if (size != other.size) return false

        return true
    }

    override fun hashCode(): Int {
        var result = children?.hashCode() ?: 0
        result = 31 * result + size
        return result
    }
}