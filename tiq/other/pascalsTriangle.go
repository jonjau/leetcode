package other

import (
	"fmt"
)

// RunPascalsTriangle _
// Given a non-negative integer numRows, generate the first numRows of
// Pascal's triangle.
//
// In Pascal's triangle, each number is the sum of the two numbers directly
// above it.
// Example:
//
// Input: 5
// Output:
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]
func RunPascalsTriangle() {
	res := generate(5)
	fmt.Println(res)
}

// given a row in pascal's triangle return the row that follows it
func nextLine(row []int) []int {
	n := len(row)
	next := make([]int, n + 1)
	next[0] = 1
	next[n] = 1
	for i := 1; i < n; i++ {
		next[i] = row[i-1] + row[i]
	}
	return next
}

// O(n^2) time, O(n^2) space
func generate(numRows int) [][]int {
	triangle := [][]int{}
	if numRows <= 0 {
		return triangle
	}
	triangle = append(triangle, []int{1})
	for i := 1; i < numRows; i++ {
		triangle = append(triangle, nextLine(triangle[i-1]))
	}
	return triangle
}