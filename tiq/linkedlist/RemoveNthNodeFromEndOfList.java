package tiq.linkedlist;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <p>
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {
    public static void run() {
        ListNode l1 = new ListNode(1);
        l1.append(2).append(3).append(4).append(5);
        removeNthNodeFromEndOfList2(l1, 2);

        ListNode l2 = new ListNode(1);
        removeNthNodeFromEndOfList2(l2, 1);
    }

    /**
     * two pass method: calculate length in one pass, then do deletion in another
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param head the first ListNode in the list
     * @param n    position of the node to be deleted from the end of the list (not zero offset)
     * @return the head of the list after deletion
     */
    public static ListNode removeNthNodeFromEndOfList1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // calculate length of list
        int length = 0;
        ListNode temp = head;
        for (; temp != null; temp = temp.next) {
            length++;
        }
        // get to the (L-n)th element which is at index L-n-1 or (L-n)th position,
        // to delete the (L-n+1)th element.
        // the "dummy" node is used to simplify some corner cases such as a list with only one node,
        // or removing the head of the list.
        temp = dummy;
        int pos = 0;
        while (pos < length - n) {
            pos++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }

    /**
     * one pass method: maintain two pointers strictly n nodes apart, move the first past the last
     * node then delete the node at the second pointer.
     * <p>
     * faster than two pass method.
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param head the first ListNode in the list
     * @param n    position of the node to be deleted from the end of the list (not zero offset)
     * @return the head of the list after deletion
     */
    public static ListNode removeNthNodeFromEndOfList2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // advance the first pointer n+1 steps/gaps from dummy, this equates to 2 nodes in
        // between the first and second pointer
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        // advance both pointers until first pointer goes past the last node of the list
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
