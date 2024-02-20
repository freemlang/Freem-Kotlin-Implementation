package freem.utilities.collections.trie

interface MutableTrie<out Type>: Trie<Type>, MutableCollection<List<@UnsafeVariance Type>>