package tdc1.wk4;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
 * following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1. put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before
 * inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 "capacity" )
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3*cache.get(4);       // returns 4
 */
public class LRUCache {
    HashMap<Integer, Node> map;
    Node head, tail;
    int capacity;
    int count;

    /**
     * Node with 2 links
     */
    private static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Adds a node after the head of the cache, effectively making node the "first" in the list
     * <p>
     * O(1) time, O(1) space
     * </p>
     *
     * @param node node to be added to the "front"
     */
    private void addNode(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    /**
     * Deletes a given node, removing it from the cache
     * <p>
     * O(1) time, O(1) space
     * </p>
     *
     * @param node node to be removed from the cache
     */
    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * Initialises an LRUCache with the given capacity
     * <p>
     * O(1) time, O(1) space
     * </p>
     *
     * @param capacity how many items the cache can store at any given moment
     */
    private LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.map = new HashMap<>();

        // don't put head and tail in the map
        // in this implementation, head and tail will never be changed.
        // they exist solely to remove corner cases when adding and deleting nodes
        // (no null checks needed in those methods)
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }

    /**
     * Gets and returns the integer value associated with the given key, and -1 otherwise.
     * Puts the corresponding node in "front" of the cache.
     * <p>
     * O(1) time, O(1) space
     * </p>
     *
     * @param key the key
     * @return the value of key, if any, otherwise -1
     */
    private int get(int key) {
        Node node = map.get(key);
        // if that key has never been set before,
        // or is now not in the cache anymore, return -1
        if (node != null) {
            int result = node.value;
            // move the node to the "front", since we just accessed it
            deleteNode(node);
            addNode(node);
            return result;
        }
        return -1;
    }

    /**
     * Sets the value of key to value, and stores it in the cache, overriding previous values of
     * that key or puts in the a new space in the cache (deleting "old" items to make space
     * if necessary)
     * <p>
     * O(1) time, O(1) space
     * </p>
     *
     * @param key   the key
     * @param value the value to assign to key in the cache
     */
    private void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            // overriding existing item: assign new value,
            // and move it to the "front", since we just accessed it.
            node.value = value;
            deleteNode(node);
            addNode(node);
        } else {
            // empty/new key, make a new node for it
            node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                // space available: keep track of addition
                count++;
            } else {
                // cache full: delete "last" node, and its key in the map to make space
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            // move it to the "front", since we just accessed it
            addNode(node);
        }
    }

    /**
     * @return the String representation of the LRU Cache, similar to a list
     */
    public String asString() {
        Node curr = head.next;
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        while (curr.next != null) {
            String valueString = String.valueOf(curr.value);
            sb.append(valueString);
            if (curr.next.next != null) {
                sb.append(", ");
            }
            curr = curr.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    /**
     * Prints out the contents of the LRU Cache
     */
    public void displayCache() {
        System.out.println(this.asString());
    }

    public static void run() {
        int x;
        int capacity = 2;
        LRUCache cache = new LRUCache(capacity);
        cache.displayCache();
        cache.put(1, 1);
        cache.displayCache();
        cache.put(2, 2);
        cache.displayCache();
        x = cache.get(1);       // returns 1
        System.out.println("Got " + x);
        cache.displayCache();
        cache.put(3, 3);    // evicts key 2
        cache.displayCache();
        x = cache.get(2);       // returns -1 (not found)
        System.out.println("Got " + x);
        cache.displayCache();
        cache.put(4, 4);    // evicts key 1
        cache.displayCache();
        x = cache.get(1);       // returns -1 (not found)
        System.out.println("Got " + x);
        cache.displayCache();
        x = cache.get(3);       // returns 3*cache.get(4);       // returns 4
        System.out.println("Got " + x);
        cache.displayCache();
    }
}
