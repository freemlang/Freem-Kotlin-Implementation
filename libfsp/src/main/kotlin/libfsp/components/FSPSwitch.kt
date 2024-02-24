package libfsp.components

import libfsp.reference.FSPValue

data class FSPSwitch<Type, Return> internal constructor(internal val components: List<Pair<FSPComponent<Type, *>, FSPValue<Return>>>): FSPComponent<Type, Return>