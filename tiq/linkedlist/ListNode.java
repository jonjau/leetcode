package tiq.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    /**
     * @param x value that this ListNode contains
     */
    public ListNode(int x) {
        val = x;
    }

    /**
     * Appends a new ListNode to this node with the given value
     * @param val the value which the new node is to contain
     * @return the appended ListNode
     */
    public ListNode append(int val) {
        ListNode newNode = new ListNode(val);
        this.next = newNode;
        return newNode;
    }
}