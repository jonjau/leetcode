package math

import (
	"fmt"
	"strconv"
)

// Write a program that outputs the string representation of numbers from 1 to
// n. But for multiples of three it should output “Fizz” instead of the number
// and for the multiples of five output “Buzz”. For numbers which are multiples
// of both three and five output “FizzBuzz”.
func fizzBuzz(n int) []string {
	res := make([]string, n)
	for i := 0; i < n; i++ {
		if x := i + 1; x%15 == 0 {
			res[i] = "FizzBuzz"
		} else if x%5 == 0 {
			res[i] = "Buzz"
		} else if x%3 == 0 {
			res[i] = "Fizz"
		} else {
			res[i] = strconv.Itoa(x)
		}
	}
	return res
}

// Run Fizzbuzz
func RunFizzBuzz() {
	ans := fizzBuzz(100)
	fmt.Println(ans)
}