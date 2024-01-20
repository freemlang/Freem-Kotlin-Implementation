package freem.utilities.collections.trie

fun emptyTrie(): Trie = EmptyTrie

fun trieOf(): Trie = emptyTrie()
fun trieOf(vararg word: String): Trie = if (word.isNotEmpty()) HashTrie(word.asList()) else emptyTrie()
fun mutableTrieOf(): MutableTrie = HashTrie()
fun mutableTrieOf(vararg word: String): MutableTrie = HashTrie(word.asList())