package typeful.option

data object None : Option<Nothing>() {
    override fun clone(): None {
        return None
    }
}
