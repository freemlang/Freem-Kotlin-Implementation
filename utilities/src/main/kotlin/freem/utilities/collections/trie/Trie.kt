package freem.utilities.collections.trie

interface Trie<out Type>: TrieNode<Type>, Collection<List<Type>> {
    override val children: Map<@UnsafeVariance Type, TrieNode<Type>>?
    override operator fun get(key: @UnsafeVariance Type) = children?.get(key)
}