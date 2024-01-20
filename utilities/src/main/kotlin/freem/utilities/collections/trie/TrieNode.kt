package freem.utilities.collections.trie

interface TrieNode {
    val isLeaf: Boolean
    val children: Map<Char, TrieNode>?
    operator fun get(char: Char) = children?.get(char)
}