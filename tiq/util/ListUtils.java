package tiq.util;

import tiq.linkedlist.ListNode;

public class ListUtils {
    public static String asString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(" -> ");
            }
            head = head.next;
        }
        return sb.toString();
    }

    public static ListNode fromArray(int[] array) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy.next;
        for (int value : array) {
            temp.append(value);
        }
        return dummy.next;
    }
}
