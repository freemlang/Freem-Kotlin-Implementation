package freem.utilities.collections.trie

import freem.utilities.collections.Trie
import freem.utilities.collections.TrieNode

internal object EmptyTrie: Trie {
    override fun equals(other: Any?): Boolean = other is Trie && other.isEmpty()
    override fun hashCode(): Int = 0
    override fun toString(): String = "{ isLeaf=false, children=null }"

    override val isLeaf: Boolean = false
    override val children: Map<Char, TrieNode>? = null
    override val size: Int = 0

    override fun contains(element: String): Boolean = false
    override fun containsAll(elements: Collection<String>): Boolean = false
    override fun isEmpty(): Boolean = true
    override fun iterator(): Iterator<Nothing> = iterator()
}