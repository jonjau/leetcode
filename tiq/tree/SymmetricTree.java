package tiq.tree;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * Iterative method using queue (SIMILAR TO BREADTH-FIRST SEARCH)
     * <p>
     *     O(n) time, O(n) space
     * </p>
     *
     * Instead of recursion, we can also use iteration with the aid of a queue. Each two consecutive
     * nodes in the queue should be equal, and their subtrees a mirror of each other. Initially, the
     * queue contains root and root. Then the algorithm works similarly to BFS, with some key
     * differences. Each time, two nodes are extracted and their values compared. Then, the right
     * and left children of the two nodes are inserted in the queue in opposite order. The algorithm
     * is done when either the queue is empty, or we detect that the tree is not symmetric (i.e. we
     * pull out two consecutive nodes from the queue that are unequal).
     *
     * @param root the root node of the binary tree
     * @return whether the given binary tree is symmetric
     */
    public static boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        // start with both "pointers" at root, then they will diverge
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }
}
