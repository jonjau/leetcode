package math

import "fmt"

// O(n^2) time, O(1) space
// look up eratosthenes...
func countPrimes1(n int) int {
	if n < 0 {
		return 0
	}
	count := 0
	for i := 0; i < n; i++ {
		if isPrime(i) {
			count++
		}
	}
	return count
}

// O(n) time, O(1) space
func isPrime(x int) bool {
	if x <= 1 {
		return false
	}
	for i := 2; i*i <= x; i++ {
		if x%i == 0 {
			return false
		}
	}
	return true
}

// RunCountPrimes _
func RunCountPrimes() {
	cases := []int{-3, 0, 1, 2, 5, 10, 17}
	res := []int{}
	for _, c := range cases {
		res = append(res, countPrimes1(c))
	}
	fmt.Println(res)
}
