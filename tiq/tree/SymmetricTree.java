package tiq.tree;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * <p>
 * But the following [1,2,2,null,3,null,3] is not:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * <p>
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
    public static boolean run() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        boolean ans = isSymmetric1(node1);
        System.out.println(ans);
        return ans;
    }

    /**
     * Recursive method that checks if the two trees given by the two nodes are mirror images
     * of each other
     *
     * @param node1 root node of the first tree
     * @param node2 root node of the second tree
     * @return whether the two given trees are mirror images of each other
     */
    public static boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        // a tree is a mirror image of another if their root values are the same and:
        // the left (right) subtree of one is the mirror image of the other's right (left) subtree
        return node1.val == node2.val
                && isMirror(node1.left, node2.right)
                && isMirror(node1.right, node2.left);
    }

    /**
     * Checks if the given binary tree is symmetric around its center
     * <p>
     * O(n) time, O(n) space
     * </p>
     * <p>
     * Because we traverse the entire input tree once and the number of recursive
     * calls is bound by the height of the tree
     *
     * @param root the root node of the binary tree
     * @return whether the given binary tree is symmetric around its center
     */
    public static boolean isSymmetric1(TreeNode root) {
        return isMirror(root, root);
    }
}
