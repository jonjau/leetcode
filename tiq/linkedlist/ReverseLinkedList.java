package tiq.linkedlist;

import tiq.util.ListUtils;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * <p>
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    public static ListNode run() {
        ListNode l1 = new ListNode(1);
        l1.append(2).append(3).append(4);
        System.out.println(ListUtils.asString(l1));
        ListNode l2 = reverseLinkedList1(l1);
        System.out.println(ListUtils.asString(l2));
        return l2;
    }

    /**
     * Iterative approach:
     * use two pointers and essentially reverse the pointing directions pairwise
     * <p>
     * turn 1 -> 2 -> 3 -> NULL into NULL <- 1 <- 2 <- 3
     * <p>
     * O(n) time, O(1) space
     *
     * @param head the head of the linked list to be reversed
     * @return the head of the reversed list
     */
    public static ListNode reverseLinkedList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        return prev;
    }

    /**
     * The recursive version is slightly trickier and the key is to work backwards. Assume that the
     * rest of the list had already been reversed, now how do I reverse the front part? Let's assume
     * the list is: n1 → … → nk-1 → nk → nk+1 → … → nm → Ø
     * <p>
     * Assume from node nk+1 to nm had been reversed and you are at node nk.
     * <p>
     * n1 → … → nk-1 → nk → nk+1 ← … ← nm
     * <p>
     * We want nk+1’s next node to point to nk. so nk.next.next = nk;
     * <p>
     * Be very careful that n1's next must point to Ø. If you forget about this, your linked list
     * has a cycle in it. This bug could be caught if you test your code with a linked list of size
     * 2.
     *
     * <p>
     * O(n) time, O(n) space
     *
     * @param head the head of the linked list to be reversed
     * @return the head of the reversed linked list
     */
    public static ListNode reverseLinkedList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseLinkedList1(head.next);
        // head is the 'next' of two pointers (in the middle of reversing)
        // but it does not have a next
        head.next.next = head;
        head.next = null;
        return p;
    }
}
