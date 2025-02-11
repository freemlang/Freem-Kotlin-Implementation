// import kotlinx.coroutines.channels.Channel
// import kotlinx.coroutines.launch
// import kotlinx.coroutines.runBlocking
//
// fun main() {
//    runBlocking {
//        val aChannel = Channel<Unit>()
//        val bChannel = Channel<Unit>()
//
//        val aJob = launch {
//            println("a unlock 1")
//            aChannel.receive()
//
//            println("a unlock 2")
//            aChannel.receive()
//
//            println("a unlock 3")
//            aChannel.receive()
//
//            println("a unlock 4 fin")
//        }
//        val bJob = launch {
//            println("b unlock 1")
//            bChannel.receive()
//
//            println("b unlock 2 fin")
//        }
//
//        val checker = launch {
//            while (true) {
//                println("check")
//                val aCompleted = aJob.isCompleted
//                val bCompleted = bJob.isCompleted
//                if (aCompleted && bCompleted) {
//                    return@launch
//                }
//
//                val aSend = if (!aCompleted) launch { aChannel.trySend(Unit) }
//                if ((aState || aCompleted) && (bState || bCompleted)) {
//                    if (!aCompleted && aState) {
//                        aState = false
//                        aChannel.send(Unit)
//                    }
//                    if (!bCompleted && bState) {
//                        bState = false
//                        bChannel.send(Unit)
//                    }
//                }
//            }
//        }
//
//        checker.join()
//    }
// }
//
// class Context {
//
//    fun stop() {}
// }
//
// suspend fun Context.foo() {}
