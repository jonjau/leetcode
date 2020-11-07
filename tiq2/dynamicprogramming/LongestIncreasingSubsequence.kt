package tiq2.dynamicprogramming

import kotlin.math.max

/**
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 */
fun runLongestIncreasingSubsequence() {
    val tests = listOf(
            intArrayOf(1,3,2,4,5,0),
            (1..2500).toList().toIntArray(),
            intArrayOf(10,9,2,5,3,7,101,18),
            intArrayOf(0)
    )
    tests.forEach { test ->
        println(longestIncreasingSubsequence(test))
    }
}

// DP with memoization: imperative
// O(n^2) time
// O(n) space
fun longestIncreasingSubsequence(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    val dp = IntArray(nums.size)
    dp[0] = 1
    var ans = 1
    for (i in 1 until dp.size) {
        var maxLen = 0
        for (j in 0 until i) {
            if (nums[j] < nums[i]) {
                maxLen = max(maxLen, dp[j])
            }
        }
        dp[i] = 1 + maxLen
        ans = max(ans, dp[i])
    }
    return ans
}

// tried porting from Haskell, didn't work: memory limit exceeded
fun longestIncreasingSubsequence1(nums: IntArray): Int =
        when (nums.size) {
            0 -> 0
            else -> {
                val iss = increasingSubsequences(nums.asList())
                println(iss)
                iss.maxByOrNull { it.size }!!.size
            }
        }

val <T> List<T>.tail: List<T>
    get() = drop(1)

val <T> List<T>.head: T
    get() = first()

fun increasingSubsequences(xs:List<Int>): List<List<Int>> = increasingSubsequences(xs, emptyList())
fun increasingSubsequences(xs: List<Int>, acc: List<List<Int>>): List<List<Int>> =
        when (xs.size) {
            0 -> acc
            else -> {
                val x = xs.head
                val acc1 = listOf(listOf(x), *(acc.toTypedArray())) // this bit is wrong
                val acc2 = acc1 + acc.filter { s -> s.last() < x }.map { it + x }
                increasingSubsequences(xs.tail, acc2)
            }
        }

// almost working idk
//fun longestIncreasingSubsequence(nums: IntArray): Int =
//        when (nums.size) {
//            0 -> 0
//            1 -> 1
//            else -> {
//                val res = nums.sliceArray(1 until nums.size).mapIndexed { idx, x ->
//                    val seenSoFar = nums.sliceArray(0 until idx)
//                    val seenSoFarLess = seenSoFar.filter { it < x }.toIntArray()
//                    if (seenSoFarLess.isEmpty()) {
//                        1
//                    } else {
//                        // this is probably the mistake
//                        1 + longestIncreasingSubsequence(seenSoFar)
//                    }
//                }
//                println(res)
//                res.last()
//            }
//        }
