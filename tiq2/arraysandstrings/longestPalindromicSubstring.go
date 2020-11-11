package arraysandstrings

import "fmt"

// RunLongestPalindromicSubstring _
// Given a string s, return the longest palindromic substring in s.
//
// Example 1:
//
// Input: s = "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
//
// Example 2:
//
// Input: s = "cbbd"
// Output: "bb"
//
// Example 3:
//
// Input: s = "a"
// Output: "a"
//
// Example 4:
//
// Input: s = "ac"
// Output: "a"
//
//
//
// Constraints:
//
//	1 <= s.length <= 1000
//	s consist of only digits and English letters
func RunLongestPalindromicSubstring() {
	tests := []string{
		"aba",
		"ababa",
		"asdsdaljkjlk",
		"",
		"a",
		"ab",
		"bb",
		"abb",
	}
	for _, test := range tests {
		// fmt.Println(isPalindrome(test))
		// fmt.Println(longestPalindromicSubstring(test))
		fmt.Println(longestPalindromicSubstring2(test))
	}
}

// O(n) time, O(n) space
func isPalindrome(s string) bool {
	n := len(s)
	stack := make([]byte, n/2)
	// push half of s to stack
	for i := 0; i < len(stack); i++ {
		stack[i] = s[i]
	}
	// later half of s must match stack in pop order
	for i := len(stack) - 1; i >= 0; i-- {
		if stack[i] != s[n-1-i] {
			return false
		}
	}
	return true
}

// O(n^3) time, O(n) space
// brute force: time limit exceeeded
func longestPalindromicSubstring(s string) string {
	n := len(s)
	longest := ""
	// check for each slice j:i in s, if it's a palindrome
	for i := 1; i <= n; i++ {
		for j := 0; j < i; j++ {
			if isPalindrome(s[j:i]) && i - j > len(longest) {
				longest = s[j:i]
			}
		}
	}
	return longest
}

// O(n^2) time, O(n^2) space
// DP
// slower than most submissions still...
func longestPalindromicSubstring2(s string) string {
	n := len(s)
	if n == 0 || n == 1 {
		return s
	}
	// dp[i][j] is true if s[i:j+1] is a palindrome
	dp := make([][]bool, n)
	for i := range dp {
		dp[i] = make([]bool, n)
		// initialise one and two letter substrings palindromes
		dp[i][i] = true
		if i < n - 1 {
			dp[i][i+1] = s[i] == s[i+1]
		}
	}
	// initialise palindromes of length greater than 2
	for j := 2; j < n; j++ {
		for i := 0; i < j - 1; i++ {
			dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
		}
	}
	// find in the DP grid the largest difference between j and i
	longest := s[:1]
	for j := 0; j < n; j++ {
		for i := 0; i <= j; i++ {
			if dp[i][j] && j + 1 - i > len(longest) {
				longest = s[i:j+1]
			}
		}
	}
	return longest
}