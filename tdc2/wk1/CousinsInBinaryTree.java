package tdc2.wk1;

import tiq.tree.TreeNode;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth
 * k+1.
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * <p>
 * We are given the root of a binary tree with unique values, and the values x and y of two
 * different nodes in the tree.
 * <p>
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */
public class CousinsInBinaryTree {
    public static boolean run() {
        int x = 4;
        int y = 5;
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(x);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(y);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.right = new TreeNode(x);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(y);

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.right = new TreeNode(4);
        root3.left.right.right = new TreeNode(8);
        root3.right = new TreeNode(5);

        boolean ans = cousinsInBinaryTree1(root3, 2, 8);
        System.out.println(ans);
        return ans;
    }

    private static TreeNode xParent = null;
    private static TreeNode yParent = null;
    private static int xDepth = -1;
    private static int yDepth = -1;

    /**
     * DFS approach
     * <p>
     * O(n) time, O(logn) space (for recursive stack)
     * </p>
     *
     * @param root the root node of a binary tree
     * @param x    an integer
     * @param y    an integer
     * @return whether x and y are cousins
     */
    public static boolean cousinsInBinaryTree1(TreeNode root, int x, int y) {
        _cousinsInBinaryTree1(root, 0, x, y, null);
        return xDepth == yDepth && xParent != yParent;
    }

    /**
     * Recursive helper function for cousinsInBinaryTree1().
     * Modifies class variables.
     *
     * @param node the current node being considered
     * @param x    an integer
     * @param y    an integer
     */
    private static void _cousinsInBinaryTree1(TreeNode node, int depth, int x, int y, TreeNode parent) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
        } else if (node.val == y) {
            yParent = parent;
            yDepth = depth;
        } else {
            _cousinsInBinaryTree1(node.left, depth + 1, x, y, node);
            _cousinsInBinaryTree1(node.right, depth + 1, x, y, node);
        }
    }
}
