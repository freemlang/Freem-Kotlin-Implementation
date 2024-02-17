package libfsp.components

data class GreedyRepeat<Type>(override val min: Int?, override val max: Int?): Repeat<Type>()