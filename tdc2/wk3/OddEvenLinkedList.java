package tdc2.wk3;

import tiq.linkedlist.ListNode;
import tiq.util.ListUtils;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note
 * here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes)
 * time complexity.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * <p>
 * Example 2:
 * <p>
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * <p>
 * Note:
 * <p>
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {
    public static ListNode run() {
        ListNode head = new ListNode(1);
        head.append(2).append(3).append(4).append(5);
        ListNode ans = oddEvenLinkedList1(head);
        System.out.println(ListUtils.asString(ans));
        return ans;
    }

    /**
     * Odd/even toggle approach, preserves relative order
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param head the head of the linkedlist
     * @return the head of the list where odd-index elements are grouped together,
     * followed by even-index elements
     */
    public static ListNode oddEvenLinkedList1(ListNode head) {
        // dummy first nodes to improve readability
        ListNode odds = new ListNode(0);
        ListNode evens = new ListNode(0);
        ListNode oddsHead = odds;
        ListNode evensHead = evens;
        boolean isOdd = true;
        while (head != null) {
            if (isOdd) {
                odds.next = head;
                odds = odds.next;
            } else {
                evens.next = head;
                evens = evens.next;
            }
            isOdd = !isOdd;
            head = head.next;
        }
        evens.next = null;
        odds.next = evensHead.next;
        return oddsHead.next;
    }
}
