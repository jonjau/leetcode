package tdc1.wk2;

import tiq.linkedlist.ListNode;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 *
 * Example 2:
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Note:
 *
 *     The number of nodes in the given list will be between 1 and 100.
 */
public class MiddleOfLinkedList {
    public static ListNode run() {
        ListNode l1 = new ListNode(1);
        l1.append(2).append(3).append(4).append(5);
        ListNode ans = middleOfLinkedList1(l1);
        System.out.println(ans.val);
        return ans;
    }

    /**
     * Returns the middle node (or in the case of an even number of elements, if there are two,
     * he second one) of a list
     * <p>
     *     O(n) time, O(1) space
     * </p>
     * @param head the head ListNode of the linked list
     * @return the listNode in the middle of thelist
     */
    public static ListNode middleOfLinkedList1(ListNode head) {
        ListNode slow, fast;
        slow = head;
        fast = head;
        int count = 0;
        // fast moves twice as fast as slow
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            // there is an odd number of elements
            return slow;
        } else  {
            // there is an even number of elements
            return slow.next;
        }
    }
}
