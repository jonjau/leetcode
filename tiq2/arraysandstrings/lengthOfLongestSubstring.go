package arraysandstrings

import "fmt"

// RunLengthOfLongestSubstring _
// Given a string s, find the length of the longest substring without repeating
// characters.
//
// Example 1:
//
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
//
// Example 2:
//
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
//
// Example 3:
//
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a
// substring.
//
// Example 4:
//
// Input: s = ""
// Output: 0
//
// Constraints:
//
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
func RunLengthOfLongestSubstring() {
	lolss := lengthOfLongestSubstring2
	tests := []string{
		"abcabcbb",
		"bbbbb",
		"pwwkew",
		"",
	}
	for _, test := range tests {
		fmt.Println(lolss(test))
	}
}

// doesn't work
func lengthOfLongestSubstringBad(s string) int {
	// https://www.asciihex.com/ascii-printable-characters
	// Codes 32-126: 95 printable characters in ASCII
	table := [95]bool{}
	maxLen := 0
	currLen := 0
	for _, r := range s {
		pos := r - ' '
		if table[pos]{
			table = [95]bool{}
			if currLen > maxLen {
				maxLen = currLen
			}
			currLen = 0
		} else {
			table[pos] = true
			currLen++
		}
	}
	return maxLen
}

// sliding window approach (set)
// O(n) time
// O(n) space assuming m, the size of the string dominates the size of the
// charset
func lengthOfLongestSubstring1(s string) int {
	n := len(s)
	set := make(map[byte]struct{})
	i := 0; j := 0; maxLen := 0
	for ; i < n && j < n; {
		_, ok := set[s[j]]
		if !ok {
			set[s[j]] = struct{}{}
			j++
			if j - i > maxLen {
				maxLen = j - i
			}
		} else {
			delete(set, s[i])
			i++
		}
	}
	return maxLen
}

// sliding window approach (index array)
// O(n) time
// O(m) space where m is the size of the charset
//
// The solution with the set requires at most 2n steps. In fact, it could be
// optimized to require only n steps. Instead of using a set to tell if a
// character exists or not, we could define a mapping of the characters to its
// index. Then we can skip the characters immediately when we found a repeated
// character. The reason is that if s[j]s[j]s[j] have a duplicate in the range
// [i,j)[i, j)[i,j) with index j′j'j′, we don't need to increase i little by
// little. We can skip all the elements in the range [i,j′][i, j'][i,j′] and let
// iii to be j′+1j' + 1j′+1 directly.
func lengthOfLongestSubstring2(s string) int {
	n := len(s)
	// each position corresponds to a character, the associated value is its
	// position in the string
	index := [95]int{}
	maxLen := 0
	i := 0
	for j := 0; j < n; j++ {
		pos := s[j] - ' '
		if index[pos] > i {
			i = index[pos]
		}
		if currLen := j - i + 1; maxLen < currLen {
			maxLen = currLen
		} 
		index[pos] = j + 1
	}
	return maxLen
}