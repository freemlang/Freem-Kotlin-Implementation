package freem.utilities.collections.trie

internal interface MutableTrieNode<out Type>: TrieNode<Type> {
    override var isLeaf: Boolean
    override var children: MutableMap<@UnsafeVariance Type, MutableTrieNode<@UnsafeVariance Type>>?
}