package tdc1.wk4;

/**
 * Generic doubly linked list of integers
 */
public class DoublyLinkedList {
    /**
     * Node with two links, with integer value
     */
    static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    int size;
    Node head;
    Node tail;

    public DoublyLinkedList() {
        size = 0;
    }

    /**
     * Insert node at tail
     * <p>
     * O(1) time, O(1) space
     * </p>
     *
     * @param node node to insert at tail
     */
    public void insertNodeAtTail(Node node) {
        if (node == null) {
            return;
        }
        if (size > 0) {
            node.prev = tail;
            tail.next = node;
        } else {
            // list was initially empty, so now node is head too
            head = node;
        }
        tail = node;
        size++;
    }

    /**
     * Remove a given node
     * <p>
     * O(1) time, O(1) space
     * </p>
     * @param node
     */
    public void removeNode(Node node) {
        if (node == null || size == 0) {
            return;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }
        size--;
    }

    /**
     * @return true if there are no nodes in the list, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
}