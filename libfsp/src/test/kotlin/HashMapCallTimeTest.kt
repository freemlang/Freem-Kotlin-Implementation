import java.util.UUID
import kotlin.system.measureNanoTime

fun main() {
    val keyAmount = 100000
    val testCount = 10000

    val uuidKeys = Array(keyAmount) { UUID.randomUUID() }
    val uuidHashKeys = Array(keyAmount) { uuidKeys[it].hashCode() }
    val stringKeys = Array(keyAmount) { uuidKeys[it].toString() }
    val stringHashKeys = Array(keyAmount) { stringKeys[it].hashCode() }

    val uuidMap = uuidKeys.associateWith {  }
    val uuidHashMap = uuidHashKeys.associateWith {  }
    val stringMap = stringKeys.associateWith {  }
    val stringHashMap = stringHashKeys.associateWith {  }

    var uuidElapsedSum = 0L
    var uuidHashElapsedSum = 0L
    var stringElapsedSum = 0L
    var stringHashElapsedSum = 0L

    fun <Key> elapsed(keys: Array<Key>, map: Map<Key, Unit>) = measureNanoTime { for (key in keys) map[key] }

    val unit = testCount / 100
    repeat(testCount) {
        print("\rprogress: ${(it + 1).toDouble() / unit}%")

        uuidElapsedSum += elapsed(uuidKeys, uuidMap)
        uuidHashElapsedSum += elapsed(uuidHashKeys, uuidHashMap)
        stringElapsedSum += elapsed(stringKeys, stringMap)
        stringHashElapsedSum += elapsed(stringHashKeys, stringHashMap)
    }
    println()

    val uuidElapsedAverage = uuidElapsedSum / testCount.toDouble()
    val uuidHashElapsedAverage = uuidHashElapsedSum / testCount.toDouble()
    val stringElapsedAverage = stringElapsedSum / testCount.toDouble()
    val stringHashElapsedAverage = stringHashElapsedSum / testCount.toDouble()

    println("uuid: $uuidElapsedAverage")
    println("uuid hash: $uuidHashElapsedAverage")
    println("string: $stringElapsedAverage")
    println("string hash: $stringHashElapsedAverage")
}