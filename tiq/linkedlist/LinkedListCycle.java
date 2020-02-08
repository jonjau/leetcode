package tiq.linkedlist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the
 * position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no
 * cycle in the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * Can you solve it using O(1) (i.e. constant) memory?
 */
public class LinkedListCycle {
    public static boolean run() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1;
        boolean ans = hasCycle2(node1);
        System.out.println(ans);
        return ans;
    }

    /**
     * Check if there is a cycle in the linked list: hash table solution
     * <p>
     * O(n) time, O(n) space
     * </p>
     *
     * @param head the head of the linked list
     * @return whether there is a cycle in the linked list
     */
    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * Check if there is a cycle in the linked list: fast and slow pointers solution
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param head the head of the linked list
     * @return whether there is a cycle in the linked list
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        // fast will eventually catch up to slow if there is a cycle in the list
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
