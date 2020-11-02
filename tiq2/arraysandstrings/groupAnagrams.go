package arraysandstrings

import (
	"fmt"
	"sort"
)

// RunGroupAnagrams _
// Given an array of strings strs, group the anagrams together. You can return
// the answer in any order.
//
// An Anagram is a word or phrase formed by rearranging the letters of a
// different word or phrase, typically using all the original letters exactly
// once.
//
// Example 1:
//
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
// Example 2:
//
// Input: strs = [""]
// Output: [[""]]
//
// Example 3:
//
// Input: strs = ["a"]
// Output: [["a"]]
//
//
//
// Constraints:
//
//    1 <= strs.length <= 104
//    0 <= strs[i].length <= 100
//    strs[i] consists of lower-case English letters.
func RunGroupAnagrams() {
	// groupAnagrams2 should be faster than 1, but this cannot be clearly seen
	// in conventional tests
	group := groupAnagrams1
	tests := [][]string {
		{"eat","tea","tan","ate","nat","bat"},
		{""},
		{"a"},
		{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"},
		{"dggg", "dgg"},
		{"dggg", "dgg"},
	}
	for _, strs := range tests {
		g := group(strs)
		fmt.Println(g)
	}
}

// O(n mlogm) time where m is the length of the longest string in the array
// O(nm) space since the map stores up to n things, each thing
// (only the key matters since its the extra bit, values are references) is m
// or shorter
func groupAnagrams1(strs []string) [][]string {
	anagrams := make(map[string][]string)
	for _, str := range strs {
		r := []rune(str)
		sort.Slice(r, func(i, j int) bool {
			return r[i] < r[j]
		})
		sorted := string(r)
		anagrams[sorted] = append(anagrams[sorted], str)
	}
	ans := make([][]string, 0)
	for _, a := range anagrams {
		ans = append(ans, a)
	}
	return ans
}

// charCount counts the number of occurences of lower-case English letters in
// str. It is given that strs[i] consists of lower-case English letters.
// O(n) time
// O(1) (extra) space
func charCounts(str string) [26]int{
	hashable := [26]int{}
	for _, r := range str {
		pos := r - 'a'
		hashable[pos]++
	}
	return hashable
}

// O(nm) time where m is the length of the longest string
// O(nm) space
//
// Instead of sorting, make use of lower-case English letter constraint and
// use character count arrays
func groupAnagrams2(strs []string) [][]string {
	anagrams := make(map[[26]int][]string)
	for _, str := range strs {
		h := charCounts(str)
		anagrams[h] = append(anagrams[h], str)
	}
	ans := make([][]string, 0)
	for _, a := range anagrams {
		ans = append(ans, a)
	}
	return ans
}
