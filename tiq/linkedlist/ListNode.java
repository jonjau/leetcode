package tiq.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    /**
     * @param x value that this ListNode contains
     */
    ListNode(int x) {
        val = x;
    }

    public ListNode append(int val) {
        ListNode newNode = new ListNode(val);
        this.next = newNode;
        return newNode;
    }
}