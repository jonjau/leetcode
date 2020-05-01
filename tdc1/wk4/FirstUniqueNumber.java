package tdc1.wk4;

import java.util.*;

/**
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 * <p>
 * Implement the FirstUnique class:
 * <p>
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue. int
 * showFirstUnique() returns the value of the first unique integer of the queue, and returns -1
 * if there is no such integer. void add(int value) insert value to the queue.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 * <p>
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
 * Output:
 * [null,-1,null,null,null,null,null,17]
 * <p>
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 * <p>
 * Example 3:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]]
 * Output:
 * [null,809,null,-1]
 * <p>
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^8
 * 1 <= value <= 10^8
 * At most 50000 calls will be made to showFirstUnique and add.
 */
public class FirstUniqueNumber {

    /**
     * ^^^ THIS IS VERY SIMILAR TO LRU CACHE IMPLEMENTATION
     */
    private static class FirstUnique {
        Map<Integer, DoublyLinkedList.Node> seen;
        DoublyLinkedList list;

        /**
         * Constructs the FirstUnique from an initial array of ints
         * @param nums initial numbers to add to FirstUnique
         */
        public FirstUnique(int[] nums) {
            this.seen = new HashMap<>();
            this.list = new DoublyLinkedList();
            for (int num : nums) {
                this.add(num);
            }
        }

        /**
         * <p>
         * O(1) time, O(1) space
         * </p>
         *
         * @return the first unique value that has so far been added
         */
        public int showFirstUnique() {
            //  no unique values seen
            if (list.isEmpty()) {
                return -1;
            }
            return list.head.value;
        }

        /**
         * Add a value to the FirstUnique:
         * either: value is novel and unique (for now), or it is no longer unique
         * <p>
         * O(1) time, O(1) space
         * </p>
         *
         * @param value value to add
         */
        public void add(int value) {
            if (seen.containsKey(value)) {
                // we have seen this value, and want to add another,
                // value is no longer unique, delete it from the list.
                DoublyLinkedList.Node node = seen.get(value);
                list.removeNode(node);
            } else {
                // never seen this value before, want to add it
                // add it the map of values seen and the list too.
                DoublyLinkedList.Node node = new DoublyLinkedList.Node(value);
                list.insertNodeAtTail(node);
                seen.put(value, node);
            }
        }
    }

    public static void run() {
        int[] nums = {2, 3, 5};
        FirstUnique obj = new FirstUnique(nums);
        System.out.println(obj.showFirstUnique());
        obj.add(5);
        System.out.println(obj.showFirstUnique());
        obj.add(2);
        System.out.println(obj.showFirstUnique());
        obj.add(3);
        System.out.println(obj.showFirstUnique());
    }
}
