package tiq.linkedlist;

import tiq.util.ListUtils;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public static void run() {

        int[] a = {1, 2, 4, 2, 1};
        ListNode head = ListUtils.fromArray(a);
        System.out.println(ListUtils.asString(head));
        boolean isPalindrome = isPalindrome2(head);
        System.out.println(isPalindrome);
    }

    /**
     * Checks if a list is a palindrome: single function approach
     * THIS ALTERS THE ORIGINAL INPUT LIST
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param head the head of the linked list
     * @return whether list is a palindrome
     */
    public static boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        // reverse the first portion during iteration
        ListNode fast = head, newHead = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode nextTemp = head.next;
            head.next = newHead;
            newHead = head;
            head = nextTemp;
        }
        // skip the node at central place if the list contains odd number of nodes
        if (fast != null) head = head.next;
        while (newHead != null && head != null) {
            if (newHead.val != head.val) return false;
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    /**
     * Checks if a list is a palindrome: decomposed into several helper functions
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param head the head of the linked list
     * @return whether list is a palindrome
     */
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        int n = length(head);
        // reverse the first half and return the heads of the two halves
        NodePair headsPair = reverseFirstHalf(head);
        ListNode left = headsPair.first;
        ListNode right = headsPair.second;
        // skip middle node if any
        if (n % 2 == 1) {
            right = right.next;
        }
        while (left != null || right != null) {
            if (left.val != right.val) {
                repairList(headsPair.first, headsPair.second);
                return false;
            }
            left = left.next;
            right = right.next;
        }
        repairList(headsPair.first, headsPair.second);
        return true;
    }

    private static class NodePair {
        ListNode first;
        ListNode second;
        public NodePair(ListNode first, ListNode second) {
            this.first = first;
            this.second = second;
        }
    }

    /**
     * calculates the length of the given linked list
     *
     * @param head the head of the linked list
     * @return the number of ListNodes in the linked list
     */
    private static int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * Reverses (the pointing direction) of half of the nodes (rounded down) from the left
     * @param head the head of the linked list
     * @return a NodePair containing the heads of the reversed left and right parts, respectively
     */
    private static NodePair reverseFirstHalf(ListNode head) {
        ListNode previous = null;
        int n = length(head);
        // work with two pointers: link the right one to the left one (reversing the pointing
        // direction from rightward to leftward), then move them both forward towards the right
        for (int i = 0; i < n/2 && head != null; i++) {
            ListNode temp = head.next;
            head.next = previous;
            previous = head;
            head = temp;
        }
        return new NodePair(previous, head);
    }

    /**
     * Restores a list to its original order after being reverseUntil()'d, given the NodePair that
     * method returns
     * @param leftHead the head of the reversed left part of the list
     * @param rightHead the head of the right part of the list
     */
    private static void repairList(ListNode leftHead, ListNode rightHead) {
        // similar to the process in reverseUntil()
        while (leftHead != null) {
            ListNode temp = leftHead.next;
            leftHead.next = rightHead;
            rightHead = leftHead;
            leftHead = temp;
        }
    }
}
