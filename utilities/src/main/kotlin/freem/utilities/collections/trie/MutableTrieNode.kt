package freem.utilities.collections.trie

internal interface MutableTrieNode: TrieNode {
    override var isLeaf: Boolean
    override var children: MutableMap<Char, MutableTrieNode>?
}