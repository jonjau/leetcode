package tdc.wk2;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    /**
     * https://leetcode.com/problems/min-stack/discuss/49010/Clean-6ms-Java-solution
     * another interesting approach for a similar problem:
     * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
     */
    public static void run() {
        MinStack obj = new MinStack();
        int x = 5;
        obj.push(x);
        obj.pop();
        obj.push(-3);
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.getMin();
        System.out.println(param_4);
    }

    // underlying data structure is linked list
    private Node head;

    /**
     * Insert a new integer into the MinStack in O(1) time and space
     *
     * @param x integer to be inserted
     */
    public void push(int x) {
        if (head == null) {
            // first insertion: x is also the min so far
            head = new Node(x, x);
        } else {
            // insert x with an updated min value if necessary
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    /**
     * O(1) time and space
     * Removes the topmost element in the min stack, without returning it
     */
    public void pop() {
        // literally move head, and forget about the old one
        head = head.next;
        // no need to manually deallocate anything, this is Java...
    }

    /**
     * O(1) time and space
     *
     * @return the topmost element in the stack, without modifying rest of stack
     */
    public int top() {
        return head.val;
    }

    /**
     * O(1) time and space
     *
     * @return the minimum integer that has been inserted so far
     */
    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

