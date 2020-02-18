package tiq.tree;

import java.util.Arrays;

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
        int[] values = {9, 20, 15, 7};
        Arrays.sort(values);
        System.out.println(Arrays.toString(values));

        System.out.println("\nConvert to BST:");
        TreeNode root = convertSortedArrayToBST1(values);
        return root;
    }

    /**
     * Converts a sorted array of integers to a binary search tree:
     * Recursive method
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
}
