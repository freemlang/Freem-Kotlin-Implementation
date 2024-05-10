package libfsp

data class Entity<Input, Return> internal constructor(
    val onFailure: (() -> Unit)?,
    val component: Component<Input, Return>
)