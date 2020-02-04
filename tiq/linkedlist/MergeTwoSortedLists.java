package tiq.linkedlist;

import tiq.util.ListUtils;

public class MergeTwoSortedLists {
    public static ListNode run() {
        ListNode l1 = new ListNode(1);
        l1.append(5).append(7).append(21).append(89);
        ListNode l2 = new ListNode(2);
        l2.append(7).append(9).append(19).append(20);

        System.out.println(ListUtils.asString(l1));
        System.out.println(ListUtils.asString(l2));
        ListNode l3 = mergeTwoSortedLists1(l1, l2);
        System.out.println(ListUtils.asString(l3));

        return l3;
    }

    /**
     * Merge two sorted lists, iterative approach
     * <p>
     * O(n + m) time, O(1) space
     * where n is the length of the first list and m is the length of the second list
     * </p>
     *
     * @param l1 first sorted list
     * @param l2 second sorted list
     * @return head of the merged list
     */
    public static ListNode mergeTwoSortedLists1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // link to the rest of the longer list, if any
        if (l1 != null) {
            curr.next = l1;
        } else if (l2 != null) {
            curr.next = l2;
        }
        return dummyHead.next;
    }

    /**
     * Merge two sorted lists, recursive approach
     * potential STACK OVERFLOW
     * <p>
     * O(n + m) time, O(n + m) (stack) space?
     * where n is the length of the first list and m is the length of the second list
     * </p>
     *
     * @param l1 first sorted list
     * @param l2 second sorted list
     * @return head of the merged list
     */
    public static ListNode mergeTwoSortedLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode curr;
        if (l1.val < l2.val) {
            curr = l1;
            curr.next = mergeTwoSortedLists2(l1.next, l2);
        } else {
            curr = l2;
            curr.next = mergeTwoSortedLists2(l1, l2.next);
        }
        return curr;
    }
}
