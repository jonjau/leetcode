package tiq.tree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {
    public static boolean run() {
        int[] values = {9, 20, 15, 7};
        BinarySearchTree tree = new BinarySearchTree(3);
        for (int value : values) {
            tree.add(value);
        }
        tree.traverseInOrder(tree.getRoot());

        System.out.println("\nis valid BST:");
        boolean ans = isValidBST1(tree.getRoot());
        System.out.println(ans);

        return ans;
    }

    /**
     * Checks if the given binary tree is a valid binary search tree
     * <p>
     *     O(n) space, O(n) time
     * </p>
     *
     * @param node the root node of the tree
     * @return whether the tree is a valid binary search tree
     */
    public static boolean isValidBSTRecursive(TreeNode node, Integer lowerLimit,
                                              Integer upperLimit) {
        if (node == null) {
            return true;
        }
        int value = node.val;
        // must use limits because this is BST, cannot just compare children with its parent,
        // also note children must be strictly less or greater than parent to be valid
        if (lowerLimit != null && value <= lowerLimit) return false;
        if (upperLimit != null && value >= upperLimit) return false;

        // check for validity on both subtrees, keeping in mind current limits
        if (!isValidBSTRecursive(node.right, value, upperLimit)) return false;
        if (!isValidBSTRecursive(node.left, lowerLimit, value)) return false;

        // everything checked: valid up to this point
        return true;
    }

    public static boolean isValidBST1(TreeNode root) {
        return isValidBSTRecursive(root, null, null);
    }

    // READ ANALYSIS FOR ITERATIVE SOLUTION USING STACKS
    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/
}
