package freem.utilities.collections.trie

import freem.utilities.collections.HashTrie
import freem.utilities.collections.MutableTrie
import freem.utilities.collections.Trie

fun Array<out String>.toTrie(): Trie = HashTrie(toList())
fun Collection<String>.toTrie(): Trie = HashTrie(this)
fun Sequence<String>.toTrie(): Trie = HashTrie(toList())
fun Array<out String>.toMutableTrie(): MutableTrie = HashTrie(toList())
fun Collection<String>.toMutableTrie(): MutableTrie = HashTrie(this)
fun Sequence<String>.toMutableTrie(): MutableTrie = HashTrie(toList())