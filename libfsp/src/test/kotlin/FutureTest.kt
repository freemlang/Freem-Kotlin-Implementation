import java.util.concurrent.Future
import java.util.concurrent.FutureTask

fun main() {
    val futureTask = FutureTask { "Hello, World!" }

    val thread = Thread {
        val times = 5
        repeat(times) {
            println(times - it)
            Thread.sleep(1000)
        }
        futureTask.run()
    }
    thread.start()

    val future: Future<String> = futureTask

    println(future.get())
}

