package libfsp.components

data class FSPStaticRepeat<Type>(internal val times: Int, override val component: FSPComponent<Type>): FSPRepeat<Type>()