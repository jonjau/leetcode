package tdc.wk5;

import tiq.tree.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections. The path must contain at least one node and does
 * not need to go through the root.
 */
public class BinaryTreeMaximumPathSum {
    static int maxValue;

    /**
     * A path from start to end, goes up on the tree for 0 or more steps, then goes down for 0 or
     * more steps. Once it goes down, it can't go up. Each path has a highest node, which is also
     * the lowest common ancestor of all other nodes on the path. A recursive method
     * maxPathDown(TreeNode node) (1) computes the maximum path sum with highest node is the input
     * node, update maximum if necessary (2) returns the maximum sum of the path that can be
     * extended to input node's parent.
     * <p>
     * <p>
     * O(n) time, since this is essentially post-order traversal of the tree
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param root the root of the binary tree
     * @return the maximum path sum in the tree
     */
    public static int binaryTreeMaximumPathSum1(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        _binaryTreeMaximumPathSum1(root);
        return maxValue;
    }

    /**
     * Recursive helper function for binaryTreeMaximumPathSum1(),
     * modifies maxValue
     *
     * @param node the "root" of the current subtree currently being considered
     * @return the maximum path sum of the subtree with 'node' as its root
     */
    private static int _binaryTreeMaximumPathSum1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, _binaryTreeMaximumPathSum1(node.left));
        int right = Math.max(0, _binaryTreeMaximumPathSum1(node.right));

        // The second maxValue contains the bigger between the left sub-tree and right sub-tree.
        // if (left + right + node.val < maxValue ) then the result will not include the parent
        // node which means the maximum path is in the left branch or right branch.
        maxValue = Math.max(maxValue, left + right + node.val);

        // either left branch is greater or the right, also include the current node
        return Math.max(left, right) + node.val;
    }

    public static int run() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int ans = binaryTreeMaximumPathSum1(root);
        System.out.println(ans);
        return ans;
    }
}
