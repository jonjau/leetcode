package other

import "fmt"

// RunHammingDistance _
// The Hamming distance between two integers is the number of positions at which
// the corresponding bits are different.
//
// Given two integers x and y, calculate the Hamming distance.
//
// Note:
// 0 ≤ x, y < 231.
//
// Example:
// Input: x = 1, y = 4
//
// Output: 2
//
// Explanation:
// 1   (0 0 0 1)
// 4   (0 1 0 0)
//        ↑   ↑
//
// The above arrows point to positions where the corresponding bits are
// different.
func RunHammingDistance() {
	res := hammingDistance(1, 4)
	fmt.Println(res)
}

// O(m) time where m is the number of bits in x ^ y
func hammingDistance(x int, y int) int {
	xor := x ^ y
	return count1s(xor)
}

// count1s returns the number of 1s in the binary representation of num
// O(m) where m is the number of bits
func count1s(num int) int {
	count := 0
	for ; num != 0; {
		num = num & (num - 1)
		count++
	}
	return count
}