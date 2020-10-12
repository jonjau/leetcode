package tiq.math

/**
 * Write a program that outputs the string representation of numbers from 1 to
 * n.
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”. For numbers which are multiples of
 * both three and five output “FizzBuzz”.
 */
fun runFizzBuzz() {
    val ans = fizzBuzz(25)
    println(ans.toString())
}

/**
 * Returns whether this is divisible by `d`
 */
infix fun Int.divisibleBy(d: Int): Boolean = this % d == 0

/**
 * O(n) time, O(1) space
 * @param n how many strings to print
 */
fun fizzBuzz(n: Int): List<String> {
    return List(n) {
        val x = it + 1
        when {
            x divisibleBy 15 -> "FizzBuzz"
            x divisibleBy 3 -> "Fizz"
            x divisibleBy 5 -> "Buzz"
            else -> x.toString()
        }
    }
}
