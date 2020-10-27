package timer

import kotlin.system.measureNanoTime

fun main() {
    val executionTime = measureNanoTime {
        tiq2.arraysandstrings.runThreeSum()
    }
    val seconds = executionTime / 1_000_000_000
    println("--- $seconds seconds ---")
}
