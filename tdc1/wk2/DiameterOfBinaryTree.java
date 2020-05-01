package tdc1.wk2;

import tiq.tree.BinarySearchTree;
import tiq.tree.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of
 * a binary tree is the length of the longest path between any two nodes in a tree. This path may
 * or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

    static int ans;

    public static int run() {
        BinarySearchTree tree = new BinarySearchTree(1);
        int[] nums = {2, 3, 4, 5};
        for (int num : nums) {
            tree.add(num);
        }
        int ans = diameterOfBinaryTree1(tree.getRoot());
        System.out.println(ans);
        return ans;
    }

    /**
     * Return the diameter of the binary tree: the sum of the max depths to the right and left
     * of the root
     * <p>
     * O(n) time, O(log n) space
     * </p>
     *
     * @param root root of the tree
     * @return diameter of the tree
     */
    public static int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 1;
        maxDepth(root);
        return ans - 1;
    }

    /**
     * Recursive helper function for diameterOfBinaryTree1()
     * <p>
     * O(n) time, O(log n) space
     * </p>
     *
     * @param node node from which max depth is to be determined
     * @return max depth from node downwards
     */
    private static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(node.left);
        int rightMaxDepth = maxDepth(node.right);
        // update diameter so far if needed
        ans = Math.max(ans, leftMaxDepth +  rightMaxDepth + 1);
        return 1 + Math.max(leftMaxDepth, rightMaxDepth);
    }
}
