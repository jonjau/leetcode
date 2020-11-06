package tiq2.dynamicprogramming

import kotlin.math.max

fun runLongestIncreasingSubsequence() {
    val tests = listOf(
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
