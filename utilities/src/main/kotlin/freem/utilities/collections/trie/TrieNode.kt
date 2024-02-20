package freem.utilities.collections.trie

interface TrieNode<out Type> {
    val isLeaf: Boolean
    val children: Map<@UnsafeVariance Type, TrieNode<Type>>?
    operator fun get(key: @UnsafeVariance Type) = children?.get(key)
}