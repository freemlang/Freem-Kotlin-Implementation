package freem.utilities.collections.trie

fun <Type> emptyTrie(): Trie<Type> = EmptyTrie

fun <Type> trieOf(): Trie<Type> = emptyTrie()
fun <Type> trieOf(vararg element: List<Type>): Trie<Type> = if (element.isNotEmpty()) HashTrie(element.asList()) else emptyTrie()
fun <Type> mutableTrieOf(): MutableTrie<Type> = HashTrie()
fun <Type> mutableTrieOf(vararg element: List<Type>): MutableTrie<Type> = HashTrie(element.asList())