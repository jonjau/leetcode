package tiq.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode run() {
        int[] values = {-10, -3, 0, 5, 9};
        Arrays.sort(values);
        System.out.println(Arrays.toString(values));

        System.out.println("\nConvert to BST:");
        // Iterative DFS and BFS approached are similar in speed, recursive DFS is slightly faster
        // for this specific test case
        TreeNode root = convertSortedArrayToBST3(values);
        return root;
    }

    /**
     * Converts a sorted array of integers to a (height-balanced) binary search tree:
     * Recursive method, effectively depth-first
     * <p>
     * O(n) time, O(n) space (O(logn) for the recursive stack?)
     * </p>
     *
     * @param nums a sorted array of integers
     * @return the root node of the resultant binary tree
     */
    public static TreeNode convertSortedArrayToBST1(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = convertSortedArrayToBST1Helper(nums, 0, nums.length - 1);
        return head;
    }

    /**
     * Helper method for convertSortedArrayToBST1()
     */
    public static TreeNode convertSortedArrayToBST1Helper(int[] nums, int low, int high) {
        // Done
        if (low > high) {
            return null;
        }
        // to avoid integer overflow
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = convertSortedArrayToBST1Helper(nums, low, mid - 1);
        node.right = convertSortedArrayToBST1Helper(nums, mid + 1, high);
        return node;
    }

    /**
     * Iterative DFS to convert sorted array to (height-balanced) BST
     * <p>
     * O(n) time, O(n) space
     * </p>
     *
     * @param nums the array of integers to be converted to a BST
     * @return the root node of the resultant BST
     */
    public static TreeNode convertSortedArrayToBST2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // TreeNode values are placeholders, will be assigned after it is popped from the stack
        TreeNode root = new TreeNode(0);
        Stack<MyNode> nodeStack = new Stack<>();
        nodeStack.push(new MyNode(root, 0, nums.length - 1));

        while (!nodeStack.isEmpty()) {
            MyNode currNode = nodeStack.pop();
            int medianIndex = midpoint(currNode.leftIndex, currNode.rightIndex);
            currNode.node.val = nums[medianIndex];
            // go as deep as possible on left: remember stack is LIFO
            if (currNode.rightIndex > medianIndex) {
                currNode.node.right = new TreeNode(0);
                nodeStack.push(new MyNode(currNode.node.right, medianIndex + 1, currNode.rightIndex));
            }
            if (currNode.leftIndex < medianIndex) {
                currNode.node.left = new TreeNode(0);
                nodeStack.push(new MyNode(currNode.node.left, currNode.leftIndex, medianIndex - 1));
            }
        }
        return root;
    }

    /**
     * Iterative BFS to convert sorted array to (height-balanced) BST
     * <p>
     * O(n) time, O(n) space
     * </p>
     *
     * @param nums the array of integers to be converted to a BST
     * @return the root node of the resultant BST
     */
    public static TreeNode convertSortedArrayToBST3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        final int leftIndex = 0;
        final int rightIndex = nums.length - 1;
        // TreeNode values are placeholders, will be assigned after it is polled from the queue
        TreeNode root = new TreeNode(0);
        Queue<MyNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(new MyNode(root, leftIndex, rightIndex));

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                MyNode currNode = nodeQueue.poll();
                assert currNode != null;
                int medianIndex = midpoint(currNode.leftIndex, currNode.rightIndex);
                currNode.node.val = nums[medianIndex];

                if (medianIndex != currNode.leftIndex) {
                    currNode.node.left = new TreeNode(0);
                    nodeQueue.offer(new MyNode(currNode.node.left, currNode.leftIndex, medianIndex - 1));
                }

                if (medianIndex != currNode.rightIndex) {
                    currNode.node.right = new TreeNode(0);
                    nodeQueue.offer(new MyNode(currNode.node.right, medianIndex + 1, currNode.rightIndex));
                }
            }
        }
        return root;
    }

    /**
     * Private class to encapsulate the extra information needed to convert from sorted array:
     * leftIndex and rightIndex indicate the bounds of the node's children (what section of the
     * sorted array the subtree accounts for)
     */
    private static class MyNode {
        TreeNode node;
        int leftIndex, rightIndex;

        public MyNode(TreeNode node, int leftIndex, int rightIndex) {
            this.node = node;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }

    /**
     * Returns the midpoint of the given interval (both lower and upper endpoints given are
     * inclusive), with truncation to nearest int
     *
     * @param lowerBound inclusive lower bound of the interval
     * @param upperBound inclusive upper bound
     */
    private static int midpoint(int lowerBound, int upperBound) {
        assert (lowerBound <= upperBound);
        return lowerBound + (upperBound - lowerBound) / 2;
    }
}
