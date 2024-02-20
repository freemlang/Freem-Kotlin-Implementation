package freem.utilities.collections.trie

fun <Type> Array<out List<Type>>.toTrie(): Trie<Type> = HashTrie(toList())
fun <Type> Collection<List<Type>>.toTrie(): Trie<Type> = HashTrie(this)
fun <Type> Sequence<List<Type>>.toTrie(): Trie<Type> = HashTrie(toList())
fun <Type> Array<out List<Type>>.toMutableTrie(): MutableTrie<Type> = HashTrie(toList())
fun <Type> Collection<List<Type>>.toMutableTrie(): MutableTrie<Type> = HashTrie(this)
fun <Type> Sequence<List<Type>>.toMutableTrie(): MutableTrie<Type> = HashTrie(toList())