package tiq2.arraysandstrings

/**
Given an array nums of n integers, are there elements a, b, c in nums such
that a + b + c = 0? Find all unique triplets in the array which gives the sum
of zero.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:

Input: nums = []
Output: []

Example 3:

Input: nums = [0]
Output: []

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
fun runThreeSum() {
    val nums1 = intArrayOf(-1,0,1,2,-1,-4)
    val nums2 = intArrayOf(-2,0,1,1,2)
    val nums3 = intArrayOf(0,0,0,0)
    println(threeSum(nums1))
    println(threeSum(nums2))
    println(threeSum(nums3))
}

/**
 * Two pointer approach
 * O(n) time, O(n) space
 */
fun twoSum(nums: List<Int>, k: Int): List<List<Int>> {
    val pairSet = HashSet<List<Int>>()
    var i = 0
    var j = nums.size - 1
    while (i < j) {
        val sum = nums[i] + nums[j]
        if (sum == k) {
            pairSet.add(listOf(nums[i], nums[j]))
        }
        if (sum < k) {
            i++
        } else {
            j--
        }
    }
    return pairSet.toList()
}

/**
 * Very slow and bad implementation, but original?
 * O(n^2) time, O(n^2) space
 */
fun threeSum(nums: IntArray): List<List<Int>>{
    val sorted = nums.sorted()
    val tripleSet = HashSet<List<Int>>()
    for (i in sorted.indices) {
        // a + b + c = 0 means:
        // is there b and c in this array after a, such that b + c = -a?
        val a = sorted[i]
        val pairs = twoSum(sorted.slice(i+1 until sorted.size), -a)
        val triples = pairs.map { pair -> listOf(a) + pair}
        tripleSet.addAll(triples)
    }
    return tripleSet.toList()
}
