package tdc1.wk5;

import tiq.tree.TreeNode;

/**
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check
 * if a given string is a valid sequence in such binary tree.
 * <p>
 * We get the given string from the concatenation of an array of integers arr and the concatenation
 * of all values of the nodes along a path results in a sequence in the given binary tree.
 * <p>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 * <p>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 * <p>
 * <p>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 * <p>
 * <p>
 * 1 <= arr.length <= 5000
 * 0 <= arr[i] <= 9
 * Each node's value is between [0 - 9].
 */
public class CheckIfStringIsValidSequenceFromRootToLeaves {

    public static boolean run() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.left.left.right= new TreeNode(1);
        int[] arr = {0,1,0,1};
        boolean ans = checkIfStringIsValidSequenceFromRootToLeaves1(root, arr);
        System.out.println(ans);
        return ans;
    }

    /**
     * Recursive DFS approach
     * <p>
     * O(n) time (?), O(n) space, where n is the number of nodes in the binary tree
     * </p>
     *
     * @param root the root node of a binary tree
     * @param arr  an array og integers, representing the "sequence"
     * @return whether there exists a path from root to a leaf where the values of the node
     * form a sequence arr.
     */
    public static boolean checkIfStringIsValidSequenceFromRootToLeaves1(TreeNode root, int[] arr) {
        return _check(root, arr, 0);
    }

    /**
     * Recursive helper function for checkIfStringIsvalidSequenceFromRootToLeaves1()
     *
     * @param curr  the root of the current subtree being considered
     * @param arr   the sequence of integers
     * @param index the current index of the sequence being considered
     */
    private static boolean _check(TreeNode curr, int[] arr, int index) {
        // first base case: reached end of tree or array, without returning true
        if (curr == null || index >= arr.length) {
            return false;
        }
        // the only return true: when curr is a leaf and its value completes the sequence
        if (curr.left == null && curr.right == null) {
            return (curr.val == arr[index] && index == arr.length - 1);
        }
        // else recurse if sequence still follows
        if (curr.val == arr[index]) {
            return _check(curr.left, arr, index + 1) || _check(curr.right, arr, index + 1);
        }
        // not a leaf, sequence is wrong
        return false;
    }
}
