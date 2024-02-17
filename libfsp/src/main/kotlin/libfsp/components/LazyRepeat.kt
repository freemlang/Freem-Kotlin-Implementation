package libfsp.components

data class LazyRepeat<Type>(override val min: Int?, override val max: Int?): Repeat<Type>()