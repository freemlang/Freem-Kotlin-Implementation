package libfsp.components

data class FSPTask<Type> internal constructor(internal val task: Runnable): FSPComponent<Type, Nothing>