package linkedlist

import (
	"fmt"
	"strconv"
	"strings"
)

// ListNode _
type ListNode struct {
	Val  int
	Next *ListNode
}

// RunAddTwoNumbers _
// You are given two non-empty linked lists representing two non-negative
// integers. The digits are stored in reverse order, and each of their nodes
// contains a single digit. Add the two numbers and return the sum as a linked
// list.
//
// You may assume the two numbers do not contain any leading zero, except the
// number 0 itself.
//
// Example 1:
//
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.
//
// Example 2:
//
// Input: l1 = [0], l2 = [0]
// Output: [0]
//
// Example 3:
//
// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]
//
// Constraints:
//
// The number of nodes in each linked list is in the range [1, 100].
//
// 0 <= Node.val <= 9
//
// It is guaranteed that the list represents a number that does not have
// leading zeros.
func RunAddTwoNumbers() {
	l1a := &ListNode{
		2, &ListNode{
			4, &ListNode{
				3, nil,
			},
		},
	}

	l2a := &ListNode{
		5, &ListNode{
			6, &ListNode{
				4, nil,
			},
		},
	}

	l1b := &ListNode{0, nil}
	l2b := &ListNode{0, nil}

	l1c := &ListNode{
		9, &ListNode{
			9, &ListNode{
				9, &ListNode{
					9, &ListNode{
						9, &ListNode{
							9, &ListNode{
								9, nil}}}}}}}
	l2c := &ListNode{
		9, &ListNode{
			9, &ListNode{
				9, &ListNode{
					9, nil}}}}

	cases := [][]*ListNode{
		{l1a, l2a},
		{l1b, l2b},
		{l1c, l2c},
	}

	for _, c := range(cases) {
		res := addTwoNumbers(c[0], c[1])
		fmt.Println(listToString(res))
	}
}

func listToString(l *ListNode) string {
	var sb strings.Builder
	for p := l; p != nil; p = p.Next {
		sb.WriteString(strconv.Itoa(p.Val))
	}
	return sb.String()
}

// Imperative, as in elementary math
//
// O(max(m, n)) time
// O(max(m, n)) space
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	dummyHead := &ListNode{0, nil}
	p := l1
	q := l2
	curr := dummyHead
	carry := 0

	for ; p != nil || q != nil; {
		x := 0
		if p != nil {
			x = p.Val
		}
		y := 0
		if q != nil {
			y = q.Val
		}

		sum := x + y + carry
		carry = sum / 10

		curr.Next = &ListNode{sum % 10, nil}
		curr = curr.Next

		if p != nil {
			p = p.Next
		}
		if q != nil {
			q = q.Next
		}
	}
	if carry > 0 {
		curr.Next = &ListNode{carry, nil}
	}
	return dummyHead.Next
}


// doesn't work for the 99999... + 9999 case
func addTwoNumbers0(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil && l2 == nil {
		return nil
	} else if l1 == nil {
		return l2
	} else if l2 == nil {
		return l1
	}
	sum := l1.Val + l2.Val
	tail := addTwoNumbers0(l1.Next, l2.Next)
	if sum < 10 {
		return &ListNode{sum, tail}
	}
	tail.Val++
	return &ListNode{sum - 10, tail}
}

func listLen(l *ListNode) int {
	if l == nil {
		return 0
	}
	len := 1
	for ; l.Next != nil; l = l.Next {
		len++
	}
	return len
}
