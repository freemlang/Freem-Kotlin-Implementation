package parser.context

import sluice.Sluice

internal class CentralSluice(var requiredAmount: UInt) {
    private var openedAmount = 0u
    private val sluice = Sluice()

    suspend fun close() {
        sluice.close()
    }

    fun open() {
        openedAmount += 1u
        if (openedAmount >= requiredAmount) {
            sluice.open()
            openedAmount = 0u
        }
    }
}
