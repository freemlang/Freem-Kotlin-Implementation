package coroutines.sluice

class ListedSluice {
    var threshold: UInt = 0u
        private set(value) {
            check(value > 0u) { "Threshold must be greater than 0" }
            field = value
        }

    var openedCount: UInt = 0u
        private set

    private val sluice = Sluice()

    suspend fun close(threshold: UInt) {
        sluice.close()
    }

    fun open() {
        check(sluice.isClosed()) { "Sluice is already opened" }
        openedCount += 1u
        if (openedCount >= threshold) {
            sluice.open()
            openedCount = 0u
        }
    }

    fun isOpened() = sluice.isOpened()

    fun isClosed() = sluice.isClosed()
}
