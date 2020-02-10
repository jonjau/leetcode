package tiq.tree;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its depth = 3.
 */
public class MaximumDepth {
    public static int run() {
        //FIXME: ITERATIVE SOLUTIONS
        return 0;
    }

    /**
     * find maximum depth of a given binary tree: recursive solution
     * <p>
     *     O(n) time, O(n) (stack) space
     * </p>
     * @param root the root of the binary tree
     * @return the maximum depth of the nodes in the tree
     */
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }


}
