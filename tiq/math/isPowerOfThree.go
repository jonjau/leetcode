package math

import (
	"fmt"
	"math"
)

// O(n) time
//
// O(1) space
func isPowerOfThree(n int) bool {
	if n <= 0 {
		return false
	}
	i := 1
	for i < n {
		i *= 3
	}
	return i == n
}

// O(???) time
//
// O(1) space
func isPowerOfThree2(n int) bool {
	// too precise??
	//epsilon := math.Nextafter(1, 2) - 1
	epsilon := 1e-10
	x := math.Log(float64(n)) / math.Log(3)
	dif := math.Abs(x - math.Trunc(x)) 
	return dif < epsilon
}

// RunIsPowerOfThree _
//
// Given an integer, write a function to determine if it is a power of three.
//
// Example 1:
// Input: 27
// Output: true
//
// Example 2:
// Input: 0
// Output: false
//
// Example 3:
// Input: 9
// Output: true
//
// Example 4:
// Input: 45
// Output: false
//
// Follow up:
// Could you do it without using any loop / recursion?
func RunIsPowerOfThree() {
	r := []bool{}
	vals := []int{9,12,0,-3}
	for _, val := range vals {
		r = append(r, isPowerOfThree2(val))
	}
	fmt.Println(r)
}
