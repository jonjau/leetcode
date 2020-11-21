package dynamicprogramming

import (
	"fmt"
	"math"
)

// RunCoinChange _
// You are given coins of different denominations and a total amount of money
// amount. Write a function to compute the fewest number of coins that you need
// to make up that amount. If that amount of money cannot be made up by any
// combination of the coins, return -1.
//
// You may assume that you have an infinite number of each kind of coin.
//
//
//
// Example 1:
//
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
//
// Example 2:
//
// Input: coins = [2], amount = 3
// Output: -1
//
// Example 3:
//
// Input: coins = [1], amount = 0
// Output: 0
//
// Example 4:
//
// Input: coins = [1], amount = 1
// Output: 1
//
// Example 5:
//
// Input: coins = [1], amount = 2
// Output: 2
func RunCoinChange() {
	tests := [][]int{
		{1, 2, 5},
		{1,3},
		{2},
		{},
	}
	for _, test := range tests {
		fmt.Println(coinChange(test, 5))
	}
}

// O(s * n) time, O(s) space where s is the amount, and n is the denomination
// count
func coinChange(coins []int, amount int) int {
	counts := make([]int, amount)
	return coinChangeRec(coins, amount, counts)
}

func coinChangeRec(coins []int, amount int, counts []int) int {
	if amount < 0 {
		return -1
	}
	if amount == 0 {
		return 0
	}
	if counts[amount-1] != 0 {
		return counts[amount-1]
	}
	min := math.MaxInt64
	for _, coin := range coins {
		res := coinChangeRec(coins, amount-coin, counts)
		if res >= 0 && res < min {
			min = 1 + res
		}
	}
	if min == math.MaxInt64 {
		counts[amount-1] = -1
	} else {
		counts[amount-1] = min
	}
	return counts[amount-1]
}
