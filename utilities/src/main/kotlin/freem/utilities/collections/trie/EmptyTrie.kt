package freem.utilities.collections.trie

internal object EmptyTrie: Trie<Nothing> {
    override fun equals(other: Any?): Boolean = other is Trie<*> && other.isEmpty()
    override fun hashCode(): Int = 0
    override fun toString(): String = "{ isLeaf=false, children=null }"

    override val isLeaf: Boolean = false
    override val children: Map<Nothing, TrieNode<Nothing>>? = null
    override val size: Int = 0

    override fun contains(element: List<Nothing>): Boolean = false
    override fun containsAll(elements: Collection<List<Nothing>>): Boolean = false
    override fun isEmpty(): Boolean = true
    override fun iterator(): Iterator<Nothing> = iterator()
}