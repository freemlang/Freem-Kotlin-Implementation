package freem.utilities.collections.trie

interface Trie: TrieNode, Collection<String> {
    override val children: Map<Char, TrieNode>?
    override operator fun get(char: Char) = children?.get(char)
}