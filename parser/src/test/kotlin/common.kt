import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import sluice.Sluice

fun main() {
    runBlocking {
        val sluice = Sluice()

        launch {
            delay(1000)
            sluice.open()
        }

        sluice.close()
        println("fin")
    }
}
