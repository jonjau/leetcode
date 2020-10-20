package other

import "fmt"

// RunReverseBits _
//
// Reverse bits of a given 32 bits unsigned integer.
//
// Note:
//
// Note that in some languages such as Java, there is no unsigned integer type.
// In this case, both input and output will be given as a signed integer type.
// They should not affect your implementation, as the integer's internal binary
// representation is the same, whether it is signed or unsigned. In Java, the
// compiler represents the signed integers using 2's complement notation.
//
// Therefore, in Example 2 above, the input represents the signed integer -3 and
// the output represents the signed integer -1073741825.
//
// Follow up:
//
// If this function is called many times, how would you optimize it?
//
// Example 1:
//
// Input: n = 00000010100101000001111010011100 Output: 964176192
// (00111001011110000010100101000000) Explanation: The input binary string
// 00000010100101000001111010011100 represents the unsigned integer 43261596, so
// return 964176192 which its binary representation is
// 00111001011110000010100101000000.
//
// Example 2:
//
// Input: n = 11111111111111111111111111111101 Output: 3221225471
// (10111111111111111111111111111111) Explanation: The input binary string
// 11111111111111111111111111111101 represents the unsigned integer 4294967293,
// so return 3221225471 which its binary representation is
// 10111111111111111111111111111111.
//
// The input must be a binary string of length 32
func RunReverseBits() {
	// expect 964176192 (00111001011110000010100101000000)
	res := reverseBits(0b00000010100101000001111010011100)
	fmt.Println(res)
	// expect 3221225471 (10111111111111111111111111111111)
	res2 := reverseBits(0b11111111111111111111111111111101)
	fmt.Println(res2)
}

// O(m) time, O(1) space, where m is the number of bits in num (32)
//
// The main idea: the bit at index i becomes the bit at index 31 - i after
// the rotation
func reverseBits(num uint32) uint32 {
	res := uint32(0)
	power := uint32(31)
	// when num == 0, there are no more 1 bits, so any reversing that
	// follows is a no-op
	for num != 0 {
		res += (num & 1) << power // reverse the bit and accumulate
		num = num >> 1            // this is how we iterate bit by bit
		power--
	}
	return res
}
